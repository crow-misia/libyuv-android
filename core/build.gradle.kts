import com.android.build.gradle.*
import org.jetbrains.dokka.gradle.DokkaTask
import java.net.URI

plugins {
    id("com.android.library")
    kotlin("android")
    id("org.jetbrains.dokka")
    id("signing")
    id("maven-publish")
}

object Maven {
    const val groupId = "io.github.crow-misia.libyuv"
    const val artifactId = "libyuv-android"
    const val name = "libyuv-android"
    const val desc = "LibYuv for Android"
    const val version = "0.15.0"
    const val siteUrl = "https://github.com/crow-misia/libyuv-android"
    const val gitUrl = "https://github.com/crow-misia/libyuv-android.git"
    const val licenseName = "The Apache Software License, Version 2.0"
    const val licenseUrl = "http://www.apache.org/licenses/LICENSE-2.0.txt"
    const val licenseDist = "repo"
    val licenses = arrayOf("Apache-2.0")
}

group = Maven.groupId
version = Maven.version

android {
    buildToolsVersion = "31.0.0"
    compileSdk = 31

    defaultConfig {
        minSdk = 9
        consumerProguardFiles("consumer-proguard-rules.pro")
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    lint {
        textReport = true
        textOutput("stdout")
    }

    libraryVariants.all {
        generateBuildConfigProvider?.configure {
            enabled = false
        }
    }

    buildTypes {
        debug {
            isJniDebuggable = false
        }
        release {
            isJniDebuggable = false
        }
    }

    externalNativeBuild {
        ndkBuild {
            path(File("${projectDir}/Android.mk"))
        }
    }
    ndkVersion = "23.1.7779620"

    sourceSets {
        getByName("androidTest").manifest {
            srcFile("src/androidTest/AndroidManifest.xml")
        }
    }

    kotlin {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict", "-module-name", "libyuv-android")
            javaParameters = true
            jvmTarget = "1.8"
            apiVersion = "1.6"
            languageVersion = "1.6"
        }
    }
}

dependencies {
    implementation(Kotlin.stdlib)

    androidTestImplementation(AndroidX.test.runner)
    androidTestImplementation(AndroidX.test.rules)
    androidTestImplementation(AndroidX.test.ext.junitKtx)
    androidTestImplementation(AndroidX.test.ext.truth)
    androidTestImplementation("com.google.truth:truth:_")
}

val sourcesJar by tasks.creating(Jar::class) {
    group = JavaBasePlugin.DOCUMENTATION_GROUP
    description = "Assembles sources JAR"
    archiveClassifier.set("sources")
    from(sourceSets.create("main").allSource)
}

val customDokkaTask by tasks.creating(DokkaTask::class) {
    dokkaSourceSets.getByName("main") {
        noAndroidSdkLink.set(false)
    }
    dependencies {
        plugins("org.jetbrains.dokka:javadoc-plugin:_")
    }
    inputs.dir("src/main/java")
    outputDirectory.set(buildDir.resolve("javadoc"))
}

val javadocJar by tasks.creating(Jar::class) {
    dependsOn(customDokkaTask)
    group = JavaBasePlugin.DOCUMENTATION_GROUP
    description = "Assembles JavaDoc JAR"
    archiveClassifier.set("javadoc")
    from(customDokkaTask.outputDirectory)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                from(components["release"])

                groupId = Maven.groupId
                artifactId = Maven.artifactId

                println("""
                    |Creating maven publication
                    |    Group: $groupId
                    |    Artifact: $artifactId
                    |    Version: $version
                """.trimMargin())

                artifact(sourcesJar)
                artifact(javadocJar)

                pom {
                    name.set(Maven.name)
                    description.set(Maven.desc)
                    url.set(Maven.siteUrl)

                    scm {
                        val scmUrl = "scm:git:_"
                        connection.set(scmUrl)
                        developerConnection.set(scmUrl)
                        url.set(Maven.gitUrl)
                        tag.set("HEAD")
                    }

                    developers {
                        developer {
                            id.set("crow-misia")
                            name.set("Zenichi Amano")
                            email.set("crow.misia@gmail.com")
                            roles.set(listOf("Project-Administrator", "Developer"))
                            timezone.set("+9")
                        }
                    }

                    licenses {
                        license {
                            name.set(Maven.licenseName)
                            url.set(Maven.licenseUrl)
                            distribution.set(Maven.licenseDist)
                        }
                    }
                }
            }
        }
        repositories {
            maven {
                val releasesRepoUrl = URI("https://oss.sonatype.org/service/local/staging/deploy/maven2")
                val snapshotsRepoUrl = URI("https://oss.sonatype.org/content/repositories/snapshots")
                url = if (Maven.version.endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
                val sonatypeUsername: String? by project
                val sonatypePassword: String? by project
                credentials {
                    username = sonatypeUsername.orEmpty()
                    password = sonatypePassword.orEmpty()
                }
            }
        }
    }

    signing {
        sign(publishing.publications.getByName("maven"))
    }
}

tasks {
    withType<Test> {
        useJUnitPlatform()
        testLogging {
            showStandardStreams = true
            events("passed", "skipped", "failed")
        }
    }
}

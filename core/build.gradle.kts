import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.jfrog.bintray.gradle.BintrayExtension

plugins {
    id("com.android.library")
    kotlin("android")
    `maven-publish`
    id("com.jfrog.bintray") version Versions.bintrayPlugin
}

group = Maven.groupId
version = Versions.name

android {
    buildToolsVersion(Versions.buildTools)
    compileSdkVersion(Versions.compileSdk)

    defaultConfig {
        minSdkVersion(Versions.minSdk)
        consumerProguardFiles("consumer-proguard-rules.pro")
    }

    lintOptions {
        textReport = true
        textOutput("stdout")
    }

    libraryVariants.all {
        generateBuildConfigProvider?.configure {
            enabled = false
        }
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = false
            isJniDebuggable = false
        }
        getByName("release") {
            isDebuggable = false
            isJniDebuggable = false
        }
    }

    externalNativeBuild {
        ndkBuild {
            setPath(File(projectDir, "src/main/jni/Android.mk"))
        }
    }
    ndkVersion = Versions.ndk
}

dependencies {
    api(kotlin("stdlib", Versions.kotlin))
}

val sourcesJar by tasks.creating(Jar::class) {
    group = JavaBasePlugin.DOCUMENTATION_GROUP
    description = "Assembles sources JAR"
    archiveClassifier.set("sources")
    from(sourceSets.create("main").allSource)
}

val publicationName = "core"
publishing {
    publications {
        create<MavenPublication>(publicationName) {
            groupId = Maven.groupId
            artifactId = Maven.artifactId
            version = Versions.name

            val releaseAar = "$buildDir/outputs/aar/${project.name}-release.aar"

            println("""
                    |Creating maven publication '$publicationName'
                    |    Group: $groupId
                    |    Artifact: $artifactId
                    |    Version: $version
                    |    Aar: $releaseAar
                """.trimMargin())

            artifact(releaseAar)
            artifact(sourcesJar)

            pom {
                name.set(Maven.name)
                description.set(Maven.desc)
                url.set(Maven.siteUrl)

                scm {
                    val scmUrl = "scm:git:${Maven.gitUrl}"
                    connection.set(scmUrl)
                    developerConnection.set(scmUrl)
                    url.set(this@pom.url)
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
}

fun findProperty(s: String) = project.findProperty(s) as String?
bintray {
    user = findProperty("bintray_user")
    key = findProperty("bintray_apikey")
    publish = true
    setPublications(publicationName)
    pkg(delegateClosureOf<BintrayExtension.PackageConfig> {
        repo = "maven"
        name = Maven.name
        desc = Maven.desc
        setLicenses(*Maven.licenses)
        setLabels(*Maven.labels)
        issueTrackerUrl = Maven.issueTrackerUrl
        vcsUrl = Maven.gitUrl
        githubRepo = Maven.githubRepo
        description = Maven.desc
    })
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

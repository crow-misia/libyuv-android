// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    kotlin("android") version Versions.kotlin apply false
}

buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Deps.androidPlugin)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

val clean by tasks.creating(Delete::class) {
    delete(rootProject.buildDir)
}

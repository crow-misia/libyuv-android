// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    kotlin("android") version Versions.kotlin apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Deps.androidPlugin)
        classpath(Deps.dokkaPlugin)
    }
}

val clean by tasks.creating(Delete::class) {
    group = "build"
    delete(rootProject.buildDir)
}

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

plugins {
    id("jp.co.gahojin.refreshVersions") version "0.6.0"
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

refreshVersions {
    sortSection = true
}

rootProject.name = "libyuv-android"
include("core")
include("sample")

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    buildToolsVersion(Versions.buildTools)
    compileSdkVersion(Versions.compileSdk)
    defaultConfig {
        applicationId = "com.github.crow_misia.libyuv"
        minSdkVersion(11)
        targetSdkVersion(Versions.targetSdk)
        versionCode = 1
        versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    lintOptions {
        textReport = true
        textOutput("stdout")
        ignore("InvalidPackage")
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    ndkVersion = Versions.ndk
}

dependencies {
    implementation(kotlin("stdlib", Versions.kotlin))
    implementation(project(":core"))
}

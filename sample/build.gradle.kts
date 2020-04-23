plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    buildToolsVersion(Versions.buildTools)
    compileSdkVersion(Versions.compileSdk)
    defaultConfig {
        applicationId = "com.example.libyuv"
        minSdkVersion(Versions.minSdk)
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
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    ndkVersion = Versions.ndk
}

dependencies {
    implementation(kotlin("stdlib", Versions.kotlin))
    implementation(project(":core"))
}

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    buildToolsVersion = "31.0.0"
    compileSdk = 31
    defaultConfig {
        applicationId = "com.github.crow_misia.libyuv"
        minSdk = 9
        targetSdk = 31
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
        debug {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":core"))
}

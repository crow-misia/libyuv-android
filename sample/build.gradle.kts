plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    buildToolsVersion = "33.0.0"
    compileSdk = 33
    defaultConfig {
        namespace = "app"
        applicationId = "com.github.crow_misia.libyuv"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    lint {
        textReport = true
    }

    buildFeatures {
        viewBinding = true
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

    kotlin {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
            apiVersion = "1.7"
            languageVersion = "1.7"
        }
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":camerax"))

    implementation(AndroidX.activity)
    implementation(AndroidX.appCompat)
}

import org.gradle.api.JavaVersion

object Build {
    const val COMPILE_SDK = 36
    const val MIN_SDK = 21
    const val TARGET_SDK = 35
    const val NDK_VERSION = "28.1.13356709"
    val jvmTarget = JavaVersion.VERSION_11
}

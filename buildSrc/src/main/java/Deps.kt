object Deps {
    const val androidPlugin = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
    const val dokkaPlugin = "org.jetbrains.dokka:dokka-gradle-plugin:${Versions.dokkaPlugin}"
    const val dokkaJavadocPlugin = "org.jetbrains.dokka:javadoc-plugin:${Versions.dokkaPlugin}"

    const val testRunner = "androidx.test:runner:${Versions.androidXTest}"
    const val testRules = "androidx.test:rules:${Versions.androidXTest}"
    const val textExtJunit = "androidx.test.ext:junit-ktx:${Versions.androidXTestExt}"
    const val testExtTruth = "androidx.test.ext:truth:${Versions.androidXTest}"
    const val truth = "com.google.truth:truth:${Versions.truth}"
}

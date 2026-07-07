import com.vanniktech.maven.publish.AndroidSingleVariantLibrary
import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.SourcesJar

plugins {
    `maven-publish`
    id("com.vanniktech.maven.publish")
    id("signing")
}

signing {
    useGpgCmd()
    sign(publishing.publications)
}

mavenPublishing {
    configure(AndroidSingleVariantLibrary(
        variant = "release",
        javadocJar = JavadocJar.Dokka("dokkaGeneratePublicationJavadoc"),
        sourcesJar = SourcesJar.Sources(),
    ))

    publishToMavenCentral()

    coordinates()
}


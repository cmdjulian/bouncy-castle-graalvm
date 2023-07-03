plugins {
    id("org.jetbrains.kotlin.jvm")
    `java-library`
    kotlin("libs.publisher")
    id("me.qoomon.git-versioning") version "6.4.2"
}

group = "de.cmdjulian"
gitVersioning.apply {
    refs {
        branch(".+") { version = "\${ref}-SNAPSHOT-\${commit.short}" }
        tag("v(?<version>.*)") { version = "\${ref.version}" }
    }
}

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
}

dependencies {
    implementation("org.graalvm.nativeimage:svm:23.0.0")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

kotlinPublications {
    publication {
        publicationName.set("graal-bouncy-castle")
        description.set("graalvm feature for registering bouncy castle")
    }
}

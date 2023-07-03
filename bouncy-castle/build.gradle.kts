import org.jetbrains.kotlinx.publisher.apache2
import org.jetbrains.kotlinx.publisher.developer
import org.jetbrains.kotlinx.publisher.githubRepo

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.8.22"
    kotlin("libs.publisher") version "0.0.61-dev-34"
}

repositories {
    mavenCentral()
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
    defaultGroup.set("com.github.cmdjulian")
    fairDokkaJars.set(false)

    pom {
        inceptionYear.set("2023")
        licenses {
            apache2()
        }
        githubRepo("cmdjulian", "bouncy-castle-graalvm")
        developers {
            developer("cmdjulian", "Julian Goede", "julian.goede@pm.me")
        }
    }

    localRepositories {
        defaultLocalMavenRepository()
    }

    publication {
        publicationName.set("graal-bouncy-castle")
        description.set("kirc core components")
    }

    publishing {
        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/cmdjulian/bouncy-castle-graalvm")
                credentials {
                    username = project.findProperty("gpr.user") as? String? ?: System.getenv("USERNAME")
                    password = project.findProperty("gpr.key") as? String? ?: System.getenv("TOKEN")
                }
            }
        }
    }
}

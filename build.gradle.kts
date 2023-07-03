import org.jetbrains.kotlinx.publisher.apache2
import org.jetbrains.kotlinx.publisher.developer
import org.jetbrains.kotlinx.publisher.githubRepo

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.8.22"
    kotlin("libs.publisher") version "0.0.61-dev-34"
}

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
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
}

subprojects {
    // only configured if subProject applies the publishing plugin
    plugins.withId("org.jetbrains.kotlin.libs.publisher") {
        publishing {
            repositories {
                maven {
                    name = "GitHubPackages"
                    url = uri("https://maven.pkg.github.com/cmdjulian/bouncy-castle-graalvm")
                    credentials {
                        username = project.findProperty("gpr.user") as? String? ?: System.getenv("GITHUB_ACTOR")
                        password = project.findProperty("gpr.key") as? String? ?: System.getenv("GITHUB_TOKEN")
                    }
                }
            }
        }
    }
}

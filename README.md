[![](https://jitpack.io/v/cmdjulian/bouncy-castle-graalvm.svg)](https://jitpack.io/#cmdjulian/bouncy-castle-graalvm)

# Bouncy Castle GraalVM Feature

GraalVM feature to contribute BouncyCastle into native image by registering it as a Security Provider.  
Just include it into your project, the Feature is auto registered and includes the proper runtime hints to initialize
most of the algorithms at build time.

## Use

<details>
<summary>Gradle</summary>

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}


dependencies {
    implementation 'com.github.cmdjulian:bouncy-castle-graalvm:{VERSION}'
}
```

</details>

<details>
<summary>Gradle Kts</summary>

```kotlin
repositories {
    maven(url = "https://jitpack.io")
}


dependencies {
    implementation("com.github.cmdjulian:bouncy-castle-graalvm:{VERSION}")
}
```

</details>

<details>
<summary>Maven</summary>

```xml

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

    ...

    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>

    ...

    <dependencies>
        <dependency>
            <groupId>com.github.cmdjulian</groupId>
            <artifactId>bouncy-castle-graalvm</artifactId>
            <version>{VERSION}</version>
        </dependency>
    </dependencies>
</project>
```

</details>
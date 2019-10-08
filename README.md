# ktlint-ruleset-junit

Custom [ktlint](https://github.com/pinterest/ktlint) ruleset for linting [JUnit](https://junit.org/junit5/) tests.

[Link to bintray](https://bintray.com/arunvelsriram/maven/ktlint-ruleset-junit)

## Setup

* Add repository:

```kotlin
repositories {
    mavenCentral()
    maven {
        setUrl("https://dl.bintray.com/arunvelsriram/maven")
    }
}
```

* Add dependency:

```kotlin
dependencies {
    ktlint("dev.arunvelsriram.ktlint.rulesets.junit:ktlint-ruleset-junit:1.0.0")
}
```

## Contributing

### Development environment

* Install [OpenJDK11](https://adoptopenjdk.net/?variant=openjdk11&jvmVariant=hotspot)
* Install [IntelliJ IDEA](https://www.jetbrains.com/idea/)

### Run test, build and generate documentation:

```bash
./gradlew clean build
```

### Release to [bintray](https://bintray.com)

* Add a Git tag for the release
* Update project version in [build.gradle.kts](./build.gradle.kts) and run:

```bash
./gradlew bintrayUpload
```

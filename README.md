# ktlint-ruleset-junit

Custom [ktlint](https://github.com/pinterest/ktlint) ruleset for linting [JUnit](https://junit.org/junit5/) tests.

[Link to bintray](https://bintray.com/arunvelsriram/maven/ktlint-ruleset-junit)

## Rules

`junit-backticked-test-description` - Checks if JUnit test description follows backticks style. For example,

```kotlin
@Test
fun `should add two numbers`() {
    assertEquals(3, add(1,2))
}
```

`junit-test-without-assertion` - Checks if JUnit test asserts anything. For example,

```kotlin
@Test
fun `should pass when test body asserts`() {
    assertTrue(true)
}
```

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

### Run test and build:

```bash
./gradlew clean build
```

### Release to [bintray](https://bintray.com)

* Add a Git tag for the release
* Update project version in [build.gradle.kts](./build.gradle.kts) and run:

```bash
./gradlew bintrayUpload
```

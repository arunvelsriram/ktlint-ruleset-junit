# ktlint-ruleset-junit

Custom [ktlint](https://github.com/pinterest/ktlint) ruleset for linting [JUnit](https://junit.org/junit5/) tests.

## Rules

`junit-test-description` - Checks if JUnit test description follows backticks style. For example,

```kotlin
@Test
fun `should add two numbers`() {
    assertEquals(3, add(1,2))
}
```

## Setup

W.I.P

## Contributing

* [OpenJDK11](https://adoptopenjdk.net/?variant=openjdk11&jvmVariant=hotspot)
* [IntelliJ IDEA](https://www.jetbrains.com/idea/)
* Run test and build:

```shell
./gradlew clean build
```

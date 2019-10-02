import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.util.Date

plugins {
    kotlin("jvm") version "1.3.50"
    id("com.jfrog.bintray") version "1.8.4"
}

group = "dev.arunvelsriram.ktlint.rulesets.junit"
version = "1.0.0"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.pinterest.ktlint:ktlint-core:0.34.2")
    compileClasspath("com.jfrog.bintray.gradle:gradle-bintray-plugin:1.8.4")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.5.2")
    testCompile("org.assertj:assertj-core:3.10.0")
    testCompile("com.pinterest.ktlint:ktlint-core:0.34.2")
    testCompile("com.pinterest.ktlint:ktlint-core:0.34.2")
    testImplementation("com.pinterest.ktlint:ktlint-test:0.34.2")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform { }
}

val currentVersion = project.version.toString()
bintray {
    user = "arunvelsriram"
    key =  System.getenv("BINTRAY_API_KEY")
    setConfigurations("archives")
    with(pkg) {
        repo = "maven"
        name = "ktlint-ruleset-junit"
        description = "Custom ktlint ruleset for linting JUnit tests."
        setLabels("kotlin", "ktlint", "junit")
        publish = true
        override = true
        publicDownloadNumbers = true
        setLicenses("Unlicense")
        vcsUrl = "https://github.com/arunvelsriram/ktlint-ruleset-junit.git"
        websiteUrl = "https://github.com/arunvelsriram/ktlint-ruleset-junit"
        issueTrackerUrl = "https://github.com/arunvelsriram/ktlint-ruleset-junit/issues"
        githubRepo = "arunvelsriram/ktlint-ruleset-junit"
        with(version) {
            name = currentVersion
            vcsTag = "v$currentVersion"
            released = Date().toString()
        }
    }
}

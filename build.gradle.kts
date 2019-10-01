import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.50"
}

group = "dev.arunvelsriram.ktlint"
version = "1.0.0"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.pinterest.ktlint:ktlint-core:0.34.2")

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

import org.gradle.internal.impldep.org.junit.experimental.categories.Categories.CategoryFilter.exclude
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.kduda"
version = "0.0.1-SNAPSHOT"

repositories {
    jcenter()
}

plugins {
    idea
    kotlin("jvm") version "1.3.11"
    id("org.jetbrains.kotlin.plugin.spring") version "1.3.11"
    id("org.springframework.boot") version "2.1.2.RELEASE"
    id("io.spring.dependency-management") version "1.0.6.RELEASE"
    id("com.github.ben-manes.versions") version "0.20.0"
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile(kotlin("reflect"))

    implementation("org.springframework.boot", "spring-boot-starter-actuator")
    implementation("org.springframework.boot", "spring-boot-starter-webflux")
    implementation("io.netty", "netty-tcnative-boringssl-static") // https on netty
    compileOnly("javax.servlet", "javax.servlet-api", "4.0.1")

    implementation("com.fasterxml.jackson.module", "jackson-module-kotlin")

    compile("io.github.microutils", "kotlin-logging", "1.6.22")

    runtimeOnly("org.springframework.boot", "spring-boot-devtools")
    compileOnly("org.springframework.boot", "spring-boot-configuration-processor")

    testImplementation("org.springframework.boot", "spring-boot-starter-test")
    testImplementation("io.projectreactor", "reactor-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        freeCompilerArgs = listOf("-Xjsr305=strict")
    }
}

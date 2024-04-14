plugins {
    // Apply the Java plugin
    java

    // Apply Spring Boot plugin
    id("org.springframework.boot") version "3.2.4"
    id("io.spring.dependency-management") version "1.1.4"
}

tasks.named("bootJar") {
    enabled = false
}

// Specify the group ID and version for your project
group = "com.example"
version = "0.0.1-SNAPSHOT"

repositories {
    // Use Maven Central for resolving dependencies
    mavenCentral()
}

dependencies {
    // Spring Boot starter web for RESTful services
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation(project(":common"))

    // Apache Commons Codec for Base32 encoding/decoding
    implementation("commons-codec:commons-codec:1.15")

    // Cassandra connecting
    implementation("com.datastax.oss:java-driver-core:4.6.1")

    // Specify other dependencies
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    // Use JUnit Jupiter for testing
    useJUnitPlatform()
}

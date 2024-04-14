plugins {
    id("java")
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // implementation("org.codehaus.groovy:groovy:4.0.3")
    implementation("org.springframework.boot:spring-boot-starter:3.2.4")
    implementation("com.datastax.oss:java-driver-core:4.13.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
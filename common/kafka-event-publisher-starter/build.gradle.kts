plugins {
//    java
    `java-library`
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

dependencies {
    // Include common protobuf
    implementation(project(":common:protobuf"))

    implementation(Dependencies.protobufJava)

    // Kafka
    implementation(Dependencies.kafkaClients)
    // Spring boot
    implementation(Dependencies.springBoot)
    implementation(Dependencies.springBootautoconfiure)

    // Logback
    implementation(Dependencies.logback)
}

// Disable bootJar (Spring Boot executable JAR) because this is a library
tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    enabled = false
}

// Enable standard JAR packaging
tasks.getByName<Jar>("jar") {
    enabled = true
}

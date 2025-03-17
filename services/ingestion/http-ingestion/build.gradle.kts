plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    java
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation(project(":common:kafka-event-publisher-starter"))

    // Protobuf
    implementation(project(":common:protobuf"))
    implementation(Dependencies.protobufJava)

    // Logback
    implementation(Dependencies.logback)
    implementation(Dependencies.logbackCore)
}


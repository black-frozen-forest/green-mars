plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    java
}

dependencies {
    implementation(Dependencies.springBoot)
    implementation(Dependencies.pahoClient)
    implementation(project(":common:kafka-event-publisher-starter"))

    // Protobuff
    implementation(project(":common:protobuf"))
    implementation(Dependencies.protobufJava)

    // Logback
    implementation(Dependencies.logback)
    implementation(Dependencies.logbackCore)
}


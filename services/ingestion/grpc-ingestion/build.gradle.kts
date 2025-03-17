plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    java
}

//extra["springGrpcVersion"] = "0.5.0"

dependencies {
    implementation(Dependencies.springBoot)
    implementation(Dependencies.grpcNetty)
    implementation(Dependencies.protobufJava)
    implementation(Dependencies.grpcProtobuf)
    implementation(Dependencies.grpcStub)
//    implementation(Dependencies.springGrpc)


//    implementation("io.grpc:grpc-services")
    implementation("org.springframework.grpc:spring-grpc-server-web-spring-boot-starter")

    // Common
    implementation(project(":common:kafka-event-publisher-starter"))
    implementation(project(":common:protobuf"))

    // Logback
    implementation(Dependencies.logback)
    implementation(Dependencies.logbackCore)
}

object Versions {
    const val grpc = "1.60.0"
    const val protobuf = "3.25.1"
    const val protobufPlugin = "0.9.4"
    const val kafka = "3.6.1"
    const val logback = "1.4.14"
    const val slf4j = "2.0.9"
    const val junit = "5.10.0"
    const val paho = "1.2.5"

    const val springBoot = "3.2.0"
    const val springDependencyManagment = "1.1.4"
}

object Dependencies {
    // Spring boot and starters
    const val springBoot = "org.springframework.boot:spring-boot-starter"
    const val springBootautoconfiure = "org.springframework.boot:spring-boot-autoconfigure"

    // Protobuf & gRPC
    const val protobufJava = "com.google.protobuf:protobuf-java:${Versions.protobuf}"
    const val grpcProtobuf = "io.grpc:grpc-protobuf:${Versions.grpc}"
    const val grpcStub = "io.grpc:grpc-stub:${Versions.grpc}"
    const val grpcNetty = "io.grpc:grpc-netty:${Versions.grpc}"
    const val javaxAnnotation = "javax.annotation:javax.annotation-api:1.3.2"
    const val springGrpc = "net.devh:grpc-server-spring-boot-starter:2.13.1.RELEASE"

    // Kafka
    const val kafkaClients = "org.apache.kafka:kafka-clients:${Versions.kafka}"

    // Logging
    const val slf4j = "org.slf4j:slf4j-api:${Versions.slf4j}"
    const val logback = "ch.qos.logback:logback-classic:${Versions.logback}"
    const val logbackCore = "ch.qos.logback:logback-core:${Versions.logback}"

    // MQTT
    const val pahoClient = "org.eclipse.paho:org.eclipse.paho.client.mqttv3:${Versions.paho}"

    // Testing
    const val junitApi = "org.junit.jupiter:junit-jupiter-api:${Versions.junit}"
    const val junitEngine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junit}"
}
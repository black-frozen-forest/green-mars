plugins {
    java
    id("com.google.protobuf")
}

dependencies {
    // Protobuf
    implementation(Dependencies.protobufJava)
    implementation(Dependencies.grpcProtobuf)
    implementation(Dependencies.grpcStub)
    implementation(Dependencies.javaxAnnotation)
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:${Versions.protobuf}"
    }
    plugins {
        create("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:${Versions.grpc}"
        }
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                create("grpc")
            }
        }
    }
}

// Enable standard JAR packaging
tasks.getByName<Jar>("jar") {
    enabled = true
}


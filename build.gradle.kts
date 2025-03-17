plugins {
    java
    id("com.google.protobuf") version Versions.protobufPlugin apply false
    id("org.springframework.boot") version Versions.springBoot apply false
    id("io.spring.dependency-management") version Versions.springDependencyManagment apply false
}

allprojects {
    group = "ai.condo"
    version = "0.1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")

    dependencies {
        implementation(Dependencies.slf4j)
        implementation(Dependencies.logback)

        testImplementation(Dependencies.junitApi)
        testRuntimeOnly(Dependencies.junitEngine)
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

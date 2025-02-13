plugins {
    // alias(libs.plugins.jvm)
    id("org.jetbrains.kotlin.jvm") version "1.9.21"
    id("com.google.protobuf") version "0.9.4"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.grpc:grpc-netty-shaded:1.60.0")
    implementation("io.grpc:grpc-protobuf:1.60.0")
    implementation("io.grpc:grpc-stub:1.60.0")
    implementation("io.grpc:grpc-services:1.60.0")
    implementation("com.google.protobuf:protobuf-java:3.24.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("javax.annotation:javax.annotation-api:1.3.2") 

    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation(libs.junit.jupiter.engine)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "server.GrpcServerKt"
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.24.0"
    }
    plugins {
        create("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.60.0"
        }
    }
    generateProtoTasks {
        all().configureEach {
            plugins {
                create("grpc")
            }
        }
    }
}
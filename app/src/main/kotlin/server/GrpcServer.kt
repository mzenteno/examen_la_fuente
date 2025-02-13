package server

import io.grpc.Server
import io.grpc.ServerBuilder
import io.grpc.protobuf.services.ProtoReflectionService


fun main() {
    val server: Server = ServerBuilder.forPort(50051)
        .addService(UserServiceImpl()) // Agrega tu servicio gRPC
        .addService(ProtoReflectionService.newInstance()) // Habilita Reflection
        .build()
        .start()

    println("gRPC Server running on port 50051")

    Runtime.getRuntime().addShutdownHook(Thread {
        println("Shutting down gRPC server...")
        server.shutdown()
    })

    server.awaitTermination()
}
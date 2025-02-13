package server

import io.grpc.Server
import io.grpc.ServerBuilder
import io.grpc.protobuf.services.ProtoReflectionService

fun main() {
    val server: Server = ServerBuilder.forPort(50051)
        .addService(UserServiceImpl2())
        .addService(ProtoReflectionService.newInstance()) // Habilita Reflection
        .build()
        .start()

    println("Servidor gRPC corriendo en el puerto 50051")
    server.awaitTermination()
}
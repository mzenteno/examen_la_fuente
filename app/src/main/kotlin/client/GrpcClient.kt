package client

import io.grpc.ManagedChannelBuilder
import user.UserServiceGrpc
import user.GetUserRequest

fun main() {
    val channel = ManagedChannelBuilder.forAddress("localhost", 50051)
        .usePlaintext()
        .build()

    val stub = UserServiceGrpc.newBlockingStub(channel)

    val request = GetUserRequest.newBuilder().setUserId("123").build()
    val response = stub.getUser(request)

    println("👤 User: ${response.name}, Email: ${response.email}")

    channel.shutdown()
}
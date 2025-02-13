package client

import io.grpc.ManagedChannelBuilder
import io.grpc.stub.StreamObserver
import user2.UserListServiceGrpc
import user2.ListUsersRequest
import user2.ListUserResponse


fun main() {
    val channel = ManagedChannelBuilder.forAddress("localhost", 50051)
        .usePlaintext()
        .build()

    val stub = UserListServiceGrpc.newStub(channel)

    val request = ListUsersRequest.newBuilder().setFilter("123").build()

    stub.listUsers(request, object : StreamObserver<ListUserResponse> {
        override fun onNext(response: ListUserResponse) {
            println("Usuario recibido: ${response.name} - ${response.email}")
        }

        override fun onError(t: Throwable) {
            println("Error en el stream: ${t.message}")
        }

        override fun onCompleted() {
            println("Stream finalizado")
        }
    })

    Thread.sleep(5000)  // Esperar para recibir la respuesta antes de cerrar
}
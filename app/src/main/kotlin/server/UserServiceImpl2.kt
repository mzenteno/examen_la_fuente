package server

import io.grpc.stub.StreamObserver

import io.grpc.Server
import io.grpc.ServerBuilder
import user2.UserListServiceGrpc
import user2.ListUsersRequest
import user2.ListUserResponse

class UserServiceImpl2 : UserListServiceGrpc.UserListServiceImplBase() {
    
    override fun listUsers(request: ListUsersRequest, responseObserver: StreamObserver<ListUserResponse>) {
        val users = listOf(
            ListUserResponse.newBuilder().setUserId("1").setName("Juan Pérez").setEmail("juan@example.com").build(),
            ListUserResponse.newBuilder().setUserId("2").setName("Ana López").setEmail("ana@example.com").build(),
            ListUserResponse.newBuilder().setUserId("3").setName("Carlos Díaz").setEmail("carlos@example.com").build()
        )

        for (user in users) {
            responseObserver.onNext(user)
            Thread.sleep(1000)  // Simulamos retardo en el streaming
        }

        responseObserver.onCompleted()  // Finaliza el streaming
    }
}
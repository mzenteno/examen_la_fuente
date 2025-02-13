package server

import io.grpc.Server
import io.grpc.ServerBuilder
import user.UserServiceGrpc
import user.GetUserRequest
import user.UserResponse

class UserServiceImpl : UserServiceGrpc.UserServiceImplBase() {
    override fun getUser(request: GetUserRequest, responseObserver: io.grpc.stub.StreamObserver<UserResponse>) {
        val response = UserResponse.newBuilder()
            .setUserId(request.userId)
            .setName("Alice")
            .setEmail("alice@example.com")
            .build()

        responseObserver.onNext(response)
        responseObserver.onCompleted()
    }
}
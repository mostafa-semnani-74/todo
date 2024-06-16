package ir.mostafa.semnani.todo.grpc.service;

import grpc.todo.TodoRequest;
import grpc.todo.TodoResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class TodoGrpcService extends grpc.todo.TodoServiceGrpc.TodoServiceImplBase {
    @Override
    public void getTodo(TodoRequest request, StreamObserver<TodoResponse> responseObserver) {
        TodoResponse response = TodoResponse.newBuilder()
                .setResMsg(request.getMsg())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

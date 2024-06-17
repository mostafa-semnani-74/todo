package ir.mostafa.semnani.todo.grpc.service;

import grpc.todo.Empty;
import grpc.todo.SaveReq;
import grpc.todo.Todo;
import grpc.todo.TodoServiceGrpc;
import io.grpc.stub.StreamObserver;
import ir.mostafa.semnani.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class TodoGrpcService extends TodoServiceGrpc.TodoServiceImplBase {
    private final TodoRepository todoRepository;

    @Override
    public void findAll(Empty request, StreamObserver<Todo> responseObserver) {
        todoRepository.findAll().forEach(todo ->
                responseObserver.onNext(
                        Todo.newBuilder()
                                .setId(todo.getId())
                                .setPriority(todo.getPriority())
                                .setDescription(todo.getDescription())
                                .setIsDone(todo.isDone())
                                .build()
                ));

        responseObserver.onCompleted();
    }

    @Override
    public void save(SaveReq request, StreamObserver<Todo> responseObserver) {
        ir.mostafa.semnani.todo.entity.Todo todoEntity = ir.mostafa.semnani.todo.entity.Todo
                .builder()
                .priority(request.getPriority())
                .description(request.getDescription())
                .isDone(request.getIsDone())
                .build();

        todoRepository.save(todoEntity);

        responseObserver.onNext(
                Todo.newBuilder()
                        .setId(todoEntity.getId())
                        .setPriority(todoEntity.getPriority())
                        .setDescription(todoEntity.getDescription())
                        .setIsDone(todoEntity.isDone())
                        .build());

        responseObserver.onCompleted();
    }
}

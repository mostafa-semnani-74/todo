package ir.mostafa.semnani.todo.service;

import ir.mostafa.semnani.todo.entity.Todo;

import java.util.List;

public interface TodoService {
    Todo save(Todo todo);
    List<Todo> findAll();
}

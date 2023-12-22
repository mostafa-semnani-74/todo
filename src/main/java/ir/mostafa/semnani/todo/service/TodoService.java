package ir.mostafa.semnani.todo.service;

import ir.mostafa.semnani.todo.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    TodoDTO save(TodoDTO todoDTO);
    List<TodoDTO> findAll();
}

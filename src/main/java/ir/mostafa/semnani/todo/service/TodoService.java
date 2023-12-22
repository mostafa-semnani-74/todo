package ir.mostafa.semnani.todo.service;

import ir.mostafa.semnani.todo.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    TodoDTO save(TodoDTO todoDTO);

    TodoDTO update(TodoDTO todoDTO);

    void deleteById(Integer id);

    List<TodoDTO> findAll();

    TodoDTO findById(Integer id);
}

package ir.mostafa.semnani.todo.service.impl;

import ir.mostafa.semnani.todo.entity.Todo;
import ir.mostafa.semnani.todo.repository.TodoRepository;
import ir.mostafa.semnani.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    @Override
    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }
}

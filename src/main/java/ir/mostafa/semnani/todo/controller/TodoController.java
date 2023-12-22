package ir.mostafa.semnani.todo.controller;

import ir.mostafa.semnani.todo.entity.Todo;
import ir.mostafa.semnani.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping
    public List<Todo> findAll() {
        return todoService.findAll();
    }

    @PostMapping
    public Todo save(@RequestBody Todo todo) {
        return todoService.save(todo);
    }
}

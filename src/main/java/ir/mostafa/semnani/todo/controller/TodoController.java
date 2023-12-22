package ir.mostafa.semnani.todo.controller;

import ir.mostafa.semnani.todo.dto.TodoDTO;
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
    public List<TodoDTO> findAll() {
        return todoService.findAll();
    }

    @PostMapping
    public TodoDTO save(@RequestBody TodoDTO todoDTO) {
        return todoService.save(todoDTO);
    }
}

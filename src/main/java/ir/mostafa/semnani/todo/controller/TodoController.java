package ir.mostafa.semnani.todo.controller;

import ir.mostafa.semnani.todo.dto.TodoDTO;
import ir.mostafa.semnani.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping
    public List<TodoDTO> findAll() {
        return todoService.findAll();
    }

    @GetMapping("{id}")
    public TodoDTO findById(@PathVariable Integer id) {
        return todoService.findById(id);
    }

    @PostMapping
    public TodoDTO save(@RequestBody TodoDTO todoDTO) {
        return todoService.save(todoDTO);
    }

    @PutMapping
    public TodoDTO update(@RequestBody TodoDTO todoDTO) {
        return todoService.update(todoDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Integer id) {
        todoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

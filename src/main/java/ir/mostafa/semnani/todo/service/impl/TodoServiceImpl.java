package ir.mostafa.semnani.todo.service.impl;

import ir.mostafa.semnani.todo.dto.TodoDTO;
import ir.mostafa.semnani.todo.entity.Todo;
import ir.mostafa.semnani.todo.mapper.TodoMapper;
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
    public TodoDTO save(TodoDTO todoDTO) {
        Todo savedTodo = todoRepository.save(TodoMapper.toEntity(todoDTO));
        return TodoMapper.toDTO(savedTodo);
    }

    @Override
    public List<TodoDTO> findAll() {
        return TodoMapper.toDTOs(todoRepository.findAll());
    }
}

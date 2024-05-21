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

    private final TodoMapper todoMapper;

    @Override
    public TodoDTO save(TodoDTO todoDTO) {
        Todo savedTodo = todoRepository.save(todoMapper.toEntity(todoDTO));
        return todoMapper.toDTO(savedTodo);
    }

    @Override
    public TodoDTO update(TodoDTO todoDTO) {
        Todo todo = findEntityById(todoDTO.id());

        todo.setPriority(todoDTO.priority());
        todo.setDescription(todoDTO.description());
        todo.setDone(todoDTO.isDone());

        return todoMapper.toDTO(todoRepository.save(todo));
    }

    @Override
    public void deleteById(Integer id) {
        todoRepository.deleteById(id);
    }

    @Override
    public List<TodoDTO> findAll() {
        return todoMapper.toDTOs(todoRepository.findAll());
    }

    @Override
    public TodoDTO findById(Integer id) {
        return todoMapper.toDTO(findEntityById(id));
    }

    private Todo findEntityById(Integer id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("todo not found with id : " + id));
    }
}

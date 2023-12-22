package ir.mostafa.semnani.todo.mapper;

import ir.mostafa.semnani.todo.dto.TodoDTO;
import ir.mostafa.semnani.todo.entity.Todo;

import java.util.List;
import java.util.stream.Collectors;

public class TodoMapper {
    public static Todo toEntity(TodoDTO todoDTO) {
        return Todo.builder()
                .priority(todoDTO.priority())
                .description(todoDTO.description())
                .isDone(todoDTO.isDone())
                .build();
    }

    public static TodoDTO toDTO(Todo todo) {
        return new TodoDTO(
                todo.getId(),
                todo.getPriority(),
                todo.getDescription(),
                todo.isDone()
        );
    }

    public static List<TodoDTO> toDTOs(List<Todo> todos) {
        return todos.stream()
                .map(TodoMapper::toDTO)
                .collect(Collectors.toList());
    }
}

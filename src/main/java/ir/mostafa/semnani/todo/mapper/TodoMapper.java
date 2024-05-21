package ir.mostafa.semnani.todo.mapper;

import ir.mostafa.semnani.todo.dto.TodoDTO;
import ir.mostafa.semnani.todo.entity.Todo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    Todo toEntity(TodoDTO todoDTO);

    TodoDTO toDTO(Todo savedTodo);

    List<TodoDTO> toDTOs(List<Todo> entities);
}

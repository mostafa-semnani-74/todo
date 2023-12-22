package ir.mostafa.semnani.todo.dto;

public record TodoDTO(Integer id,
                      Integer priority,
                      String description,
                      boolean isDone) {
}

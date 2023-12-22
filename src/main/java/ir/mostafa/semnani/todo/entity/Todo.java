package ir.mostafa.semnani.todo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Todo {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Integer priority;

    @Column
    private String description;

    @Column
    private boolean isDone;
}

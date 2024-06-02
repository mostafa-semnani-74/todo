package ir.mostafa.semnani.todo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @Version
    private Long version;
}

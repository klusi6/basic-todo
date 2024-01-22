package org.vaclavklusacek.todobasic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDo {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String description;
    private boolean isDone = false;
    private boolean isImportant;
    private String deadline;

    public ToDo (String description, boolean isImportant, String deadline) {
        this.description = description;
        this.isImportant = isImportant;
        this.deadline = deadline;
    }
}

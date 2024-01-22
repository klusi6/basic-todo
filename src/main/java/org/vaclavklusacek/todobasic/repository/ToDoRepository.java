package org.vaclavklusacek.todobasic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vaclavklusacek.todobasic.model.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}

package org.vaclavklusacek.todobasic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.vaclavklusacek.todobasic.model.ToDo;
import org.vaclavklusacek.todobasic.service.ToDoService;

@SpringBootApplication
public class TodoBasicApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TodoBasicApplication.class, args);
    }
    @Autowired
    private ToDoService toDoService;

    @Override
    public void run(String... args) throws Exception {
        ToDo toDo0 = new ToDo("Test", false, "monday");
        ToDo toDo1 = new ToDo("Test", false, "sunday");
        ToDo toDo2 = new ToDo("Test", false, "friday");
        ToDo toDo3 = new ToDo("Test", false, "next friday");
        toDoService.create(toDo0);
        toDoService.create(toDo1);
        toDoService.create(toDo2);
        toDoService.create(toDo3);
    }
}

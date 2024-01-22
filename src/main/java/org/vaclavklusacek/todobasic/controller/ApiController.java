package org.vaclavklusacek.todobasic.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vaclavklusacek.todobasic.model.ToDo;
import org.vaclavklusacek.todobasic.service.ToDoService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ApiController {
    private final ToDoService toDoService;

    @GetMapping("")
    public ResponseEntity<List<ToDo>> getAll() {
        return ResponseEntity.ok(toDoService.getAll());//TODO: map to DTO
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Optional<ToDo> toDo) {
        if (toDo.isPresent() && toDo.get().getDescription()!=null && !toDo.get().getDescription().isEmpty()) {
            return ResponseEntity.ok(toDoService.add(toDo.get()));
        }//422
        return ResponseEntity.unprocessableEntity().body("invalid todo object provide at least description in body");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ToDo updatedToDo){
        return ResponseEntity.ok(toDoService.update(id,updatedToDo));//TODO: error handling
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id, @RequestBody String message){
        return ResponseEntity.ok(toDoService.delete(id,message));//TODO : error handling + better cover for unwanted del?
    }
}

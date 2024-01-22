package org.vaclavklusacek.todobasic.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaclavklusacek.todobasic.model.ToDo;
import org.vaclavklusacek.todobasic.repository.ToDoRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ToDoService {
    private final ToDoRepository toDoRepository;

    public void create(ToDo toDo) {
        toDoRepository.save(toDo);
    }

    public List<ToDo> getAll() {
        return toDoRepository.findAll();
    }

    public ToDo add(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    public ToDo findById(Long id) {

        return toDoRepository.findById(id).orElse(null);

    }

    public ToDo update(Long id, ToDo updatedToDo) {
      ToDo toDo = findById(id);//TODO: error handling
      if (updatedToDo.getDescription() == null){
         toDo.setDescription(toDo.getDescription());
      }
        toDo.setDone(updatedToDo.isDone());
        toDo.setImportant(updatedToDo.isImportant());
        toDo.setDeadline(updatedToDo.getDeadline());
        toDoRepository.save(toDo);
        return toDo;
    }

    public String delete(Long id, String message) {
        if (findById(id) == null) {
            return "you can not delete this todo";
        }
        if (findById(id) != null && message.contains("please")) {
            toDoRepository.deleteById(id);
            return "successfully deleted";
        } else {
            return "magic word";
        }
    }
}

package com.hasith.todomanagementbyme.controllers.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class ToDoService {
    private static List<ToDo> toDos = new ArrayList<>();
    private static int todoCount = 0;

    static {
        toDos.add(new ToDo(++todoCount, "hasith", "Learn Springboot", LocalDate.now().plusYears(1), false));
        toDos.add(new ToDo(++todoCount, "hasith", "Learn AWS", LocalDate.now().plusYears(2), false));
        toDos.add(new ToDo(++todoCount, "hasith", "Learn Artificial Intelligence", LocalDate.now().plusYears(3), false));
    }

//    public List<ToDo> findByName(String username) {
//        return toDos;
//    }

    public List<ToDo> findByUsername(String username){
        Predicate<? super ToDo> predicate = toDo -> toDo.getUsername().equalsIgnoreCase(getLoggedInUsername());
        return toDos.stream().filter(predicate).toList();
    }

    public void addToDo(String username, String description, LocalDate targetDate, boolean done) {
        ToDo toDo = new ToDo(++todoCount, username, description, targetDate, done);
        toDos.add(toDo);
    }

    public void deleteByid(int id) {
        Predicate<? super ToDo> predicate = toDo -> toDo.getId() == id;
        toDos.removeIf(predicate);
    }

    public ToDo findById(int id) {
        Predicate<? super ToDo> predicate = toDo -> toDo.getId() == id;
        ToDo toDo = toDos.stream().filter(predicate).findFirst().get();
        System.out.println(toDo);
        return toDo;
    }

    public void updateTodo(@Valid ToDo toDo) {
        deleteByid(toDo.getId());
        toDos.add(toDo);
    }

    private String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}

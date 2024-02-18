package com.hasith.todomanagementbyme.controllers.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {
    private static List<ToDo> toDos = new ArrayList<>();
    private static  int todoCount =0;

    static {
        toDos.add(new ToDo(++todoCount,"Hasith Malshan" , "Learn Springboot", LocalDate.now().plusYears(1),false));
        toDos.add(new ToDo(++todoCount,"Hasith Malshan" , "Learn AWS", LocalDate.now().plusYears(2),false));
        toDos.add(new ToDo(++todoCount,"Hasith Malshan" , "Learn Artificial Intelligence", LocalDate.now().plusYears(3),false));
    }

    public List<ToDo> findByName(String username){
        return toDos;
    }

    public void addToDo(String username , String description , LocalDate targetDate,  boolean done){
        ToDo toDo = new ToDo(++todoCount,username,description,targetDate,done);
        toDos.add(toDo);
    }


}

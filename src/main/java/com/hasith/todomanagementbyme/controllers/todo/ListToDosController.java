package com.hasith.todomanagementbyme.controllers.todo;

import jakarta.validation.Valid;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@Controller
public class ListToDosController {

    private ToDoService toDoService;

    public ListToDosController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @RequestMapping(path = "list-todos")
    public String listTodos(ModelMap modelMap){
        modelMap.put("todos" , toDoService.findByName("hasith"));
        return "list-todos";
    }

    @RequestMapping(path = "add-todo", method = RequestMethod.GET)
    public String addNewTodo(ModelMap modelMap){
        ToDo  toDo = new ToDo(
                0,
                (String)modelMap.get("username"),
                "",
                LocalDate.now().plusYears(1),
                false
        );
        modelMap.put("toDo" , toDo);
        return "add-todo";
    }

    @RequestMapping(path = "add-todo", method = RequestMethod.POST)
    public String addNewTodo( ModelMap modelMap , @Valid ToDo toDo, BindingResult result){

        System.out.println("validation error ditected before if");

        if (result.hasErrors()){
            System.out.println("validation error ditected");
            return "add-todo";
        }

        System.out.println("validation error ditected after if");


        toDoService.addToDo((String) modelMap.get("username"), toDo.getDescription(), LocalDate.now().plusYears(1),false);
        return "redirect:list-todos";
    }


}

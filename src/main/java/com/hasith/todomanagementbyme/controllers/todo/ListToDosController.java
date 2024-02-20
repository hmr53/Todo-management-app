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
    public String listTodos(ModelMap modelMap) {
        modelMap.put("todos", toDoService.findByUsername((String) modelMap.get("name")));
        return "list-todos";
    }

    @RequestMapping(path = "add-todo")
    public String addNewTodo(ModelMap modelMap) {
        ToDo toDo = new ToDo(
                0,
                (String) modelMap.get("username"),
                "",
                LocalDate.now().plusYears(1),
                false
        );
        modelMap.put("toDo", toDo);
        return "add-todo";
    }

    @RequestMapping(path = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap modelMap, @Valid ToDo toDo, BindingResult result) {

        System.out.println("validation error ditected before if");

        if (result.hasErrors()) {
            System.out.println("validation error detected");
            return "add-todo";
        }

        System.out.println("validation error detected after if");


        toDoService.addToDo((String) modelMap.get("username"), toDo.getDescription(), LocalDate.now().plusYears(1), false);
        return "redirect:list-todos";
    }


    @RequestMapping(path = "delete-todo")
    public String deleteTodo(@RequestParam("id") int id) {
        toDoService.deleteByid(id);
        return "redirect:list-todos";
    }

    @RequestMapping(path = "update-todo")
    public String updateTodo(@RequestParam("id") int id, ModelMap modelMap) {
        ToDo toDoToBeUpdated = toDoService.findById(id);
        modelMap.addAttribute("toDo", toDoToBeUpdated);
        return "add-todo";
    }

    @RequestMapping(path = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap modelMap, @Valid ToDo toDo, BindingResult result) {

        if (result.hasErrors()) {
            System.out.println("validation error detected");
            return "add-todo";
        }
        toDo.setUsername((String) modelMap.get("username"));
        toDo.setTargetDate(LocalDate.now().plusYears(1));
        toDoService.updateTodo(toDo);
        return "redirect:list-todos";
    }


}

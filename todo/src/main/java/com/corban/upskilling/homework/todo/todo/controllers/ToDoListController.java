package com.corban.upskilling.homework.todo.todo.controllers;

import com.corban.upskilling.homework.todo.todo.models.ToDoList;
import com.corban.upskilling.homework.todo.todo.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoListController {

    @Autowired
    private ToDoService toDoService;

    @RequestMapping("/")
    public String index(){ return "Time for some ToDo Lists!"; }

    @PutMapping("/create-ToDoList/")
    public ToDoList createUser(@RequestBody ToDoList toDoList){
        return toDoService.createToDoList(toDoList);
    }
}

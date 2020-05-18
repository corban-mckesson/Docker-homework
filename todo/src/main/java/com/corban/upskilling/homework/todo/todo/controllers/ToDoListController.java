package com.corban.upskilling.homework.todo.todo.controllers;

import com.corban.upskilling.homework.todo.todo.models.Task;
import com.corban.upskilling.homework.todo.todo.models.ToDoList;
import com.corban.upskilling.homework.todo.todo.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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

    @PostMapping("/add-task/")
    public ToDoList addTask(@RequestBody Task task){
        return toDoService.addTask(task);
    }

    @PostMapping("/update-task/")
    public Task updateTask(@RequestBody Task task){
        return toDoService.updateTask(task);
    }

    @GetMapping("/seeAllTasks/{id}")
    public Set<Task> getAllTasks(@PathVariable("id")long toDoId){
        return toDoService.getAllTasks(toDoId);
    }

    @GetMapping("/seeAllIncompleteTasks/{id}")
    public Set<Task> getAllIncompleteTasks(@PathVariable("id")long toDoId){
        return toDoService.getAllIncompleteTasks(toDoId);
    }
}

package com.corban.upskilling.homework.todo.todo.services;

import com.corban.upskilling.homework.todo.todo.models.Task;
import com.corban.upskilling.homework.todo.todo.models.ToDoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepo toDoRepo;

    @Autowired
    private TaskRepo taskRepo;

    public ToDoList createToDoList(ToDoList toDoList){
        toDoRepo.save(toDoList);
        return toDoRepo.findById(toDoList.getId()).get();
    }

    public ToDoList addTask(Task taskToAdd){
        taskRepo.save(taskToAdd);
        ToDoList listToUpdate = toDoRepo.findById(taskToAdd.getToDoLostId()).get();
        listToUpdate.addTaskId(taskToAdd.getId());
        toDoRepo.save(listToUpdate);
        return listToUpdate;
    }

    public Task updateTask(Task task){
        taskRepo.save(task);
        return taskRepo.findById(task.getId()).get();
    }

    public Set<Task> getAllTasks(long toDoId){
        return taskRepo.findByToDoListId(toDoId);
    }
}

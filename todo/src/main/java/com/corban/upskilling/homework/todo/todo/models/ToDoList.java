package com.corban.upskilling.homework.todo.todo.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ToDoList implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long toDoListId;
    private String listName;
    @OneToMany(mappedBy = "taskId")
    private List<Task> tasks = new ArrayList<Task>();

    protected ToDoList(){}

    public ToDoList(String listName){
        this.listName = listName;
    }

    public ToDoList(String listName, Task taskToAdd){

    }

    public long getId() {
        return toDoListId;
    }

    public void setId(long toDoListId) {
        this.toDoListId = toDoListId;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}

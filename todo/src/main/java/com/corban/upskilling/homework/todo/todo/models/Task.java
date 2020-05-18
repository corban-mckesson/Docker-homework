package com.corban.upskilling.homework.todo.todo.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String taskName;
    private String taskDescription;
    private boolean completed = false;
    private long toDoListId;

    protected Task(){}

    public Task(String taskName, long toDoListId){
        this.taskName = taskName;
        this.toDoListId = toDoListId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public long getToDoLostId() {
        return toDoListId;
    }

    public void setToDoLostId(long toDoListId) {
        this.toDoListId = toDoListId;
    }
}

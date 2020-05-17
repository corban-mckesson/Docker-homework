package com.corban.upskilling.homework.todo.todo.services;

import com.corban.upskilling.homework.todo.todo.models.ToDoList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepo extends CrudRepository<ToDoList, Long> {
}

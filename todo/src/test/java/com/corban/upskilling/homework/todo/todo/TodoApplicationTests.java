package com.corban.upskilling.homework.todo.todo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TodoApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Order(1)
    void contextLoads() {
    }

    @Test
    @Order(2)
    public void createToDoList(){

    }

    @Test
    @Order(3)
    public void addTask(){

    }

    @Test
    @Order(4)
    public void updateTask(){

    }

    @Test
    @Order(5)
    public void addTaskDescription(){

    }

    @Test
    @Order(6)
    public void seeAllTasks(){

    }

    @Test
    @Order(7)
    public void completeTask(){

    }

    @Test
    @Order(8)
    public void viewCompletedTasks(){

    }

    @Test
    @Order(9)
    public void viewIncompleteTasks(){

    }

    @Test
    @Order(10)
    public void viewAllTasks(){

    }

    @Test
    @Order(11)
    public void deleteTask(){

    }
}

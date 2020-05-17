package com.corban.upskilling.homework.todo.todo;

import com.corban.upskilling.homework.todo.todo.models.Task;
import com.corban.upskilling.homework.todo.todo.models.ToDoList;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TodoApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    @Order(1)
    void contextLoads() {
    }

    @Test
    @Order(2)
    public void createToDoList(){
        try{
            mockMvc.perform(put("/create-ToDoList/").content(mapper.writeValueAsString(
                    new ToDoList("testToDo"))).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk()).andExpect(jsonPath("$.listName").value("testToDo"))
                    .andDo(print());
        } catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
    }

//    @Test
//    @Order(3)
//    public void addTask(){
//        try{
//            mockMvc.perform(post("/add-task/").content(mapper.writeValueAsString(
//                    new ToDoList("testToDo",new Task("test task")))).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isOk()).andExpect(jsonPath("$.tasks[0].taskName").value("test task"));
//        } catch (Exception e) {
//            fail("Should not have exception: " + e.getLocalizedMessage());
//        }
//    }
//
//    @Test
//    @Order(4)
//    public void updateTask(){
//        try{
//            mockMvc.perform(post("/update-task/").content(mapper.writeValueAsString(
//                    new ToDoList("testToDo",new Task("test task updated")))).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isOk()).andExpect(jsonPath("$.tasks[0].taskName").value("test task updated"));
//        } catch (Exception e) {
//            fail("Should not have exception: " + e.getLocalizedMessage());
//        }
//    }
//
//    @Test
//    @Order(5)
//    public void addTaskDescription(){
//        try{
//            mockMvc.perform(post("/update-task-description/").content(mapper.writeValueAsString(
//                    new ToDoList("testToDo",new Task("test task updated","execute order 66")))).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isOk()).andExpect(jsonPath("$.tasks[0].taskDescription").value("execute order 66"));
//        } catch (Exception e) {
//            fail("Should not have exception: " + e.getLocalizedMessage());
//        }
//    }
//
//    @Test
//    @Order(6)
//    public void seeAllTasks(){
//        try{
//            mockMvc.perform(get("/seeAllTasks/{testToDo}")).andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.listName").value("testToDo"));
//        } catch (Exception e) {
//            fail("Should not have exception: " + e.getLocalizedMessage());
//        }
//    }
//
//    @Test
//    @Order(7)
//    public void completeTask(){
//        try{
//            mockMvc.perform(post("/complete-task/").content(mapper.writeValueAsString(
//                    new ToDoList("testToDo",new Task("test task updated")))).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isOk()).andExpect(jsonPath("$.tasks[0].taskStatus").value("COMPLETED"));
//        } catch (Exception e) {
//            fail("Should not have exception: " + e.getLocalizedMessage());
//        }
//    }
//
//    @Test
//    @Order(8)
//    public void viewCompletedTasks(){
//        try{
//            mockMvc.perform(get("/seeAllCompletedTasks/{testToDo}")).andDo(print()).andExpect(status().isOk())
//                    .andExpect(jsonPath("$.tasks[0].taskName").value("test task updated"));
//        } catch (Exception e) {
//            fail("Should not have exception: " + e.getLocalizedMessage());
//        }
//    }
//
//    @Test
//    @Order(9)
//    public void viewIncompleteTasks(){
//        try{
//            mockMvc.perform(get("/seeAllIncompleteTasks/{testToDo}")).andDo(print()).andExpect(status().isOk())
//                    .andExpect(jsonPath("$.tasks[0].taskName").value("test task incomplete"));
//        } catch (Exception e) {
//            fail("Should not have exception: " + e.getLocalizedMessage());
//        }
//    }
//
//    @Test
//    @Order(10)
//    public void viewAllTasks(){
//        try{
//            mockMvc.perform(get("/seeAllTasks/{testToDo}")).andDo(print()).andExpect(status().isOk())
//                    .andExpect(jsonPath("$.tasks[0].taskName").value("test task updated"))
//                    .andExpect(jsonPath("$.tasks[1].taskName").value("test task incomplete"));
//        } catch (Exception e) {
//            fail("Should not have exception: " + e.getLocalizedMessage());
//        }
//    }
//
//    @Test
//    @Order(11)
//    public void deleteTask(){
//        try{
//            mockMvc.perform(post("/delete-task/").content(mapper.writeValueAsString(
//                    new ToDoList("testToDo",new Task("test task updated")))).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isOk()).andExpect(jsonPath("$.tasks[0].taskName").value("test task updated"));
//        } catch (Exception e) {
//            fail("Should not have exception: " + e.getLocalizedMessage());
//        }
//
//        try{
//            mockMvc.perform(get("/seeAllCompletedTasks/{testToDo}")).andDo(print()).andExpect(status().isOk())
//                    .andExpect(jsonPath("$.tasks").isEmpty());
//        } catch (Exception e) {
//            fail("Should not have exception: " + e.getLocalizedMessage());
//        }
//    }
}

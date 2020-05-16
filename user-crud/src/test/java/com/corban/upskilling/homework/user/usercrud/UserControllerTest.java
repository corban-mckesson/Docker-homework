package com.corban.upskilling.homework.user.usercrud;

import com.corban.upskilling.homework.user.usercrud.model.User;
import com.corban.upskilling.homework.user.usercrud.services.UserRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Before;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;
import org.springframework.web.util.NestedServletException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private UserRepo userRepo;


    @Test
    @Order(1)
    public void createUserTest(){
        try{
            mockMvc.perform(put("/create-user/").content(mapper.writeValueAsString(
                    new User("Billy","Bob", "bb@email.com","555-555-555"))).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk()).andExpect(jsonPath("$.firstName").value("Billy"));
        } catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
    }

    @Test
    @Order(2)
    public void readUserTestIndividualId(){
        try{
            mockMvc.perform(get("/user/1")).andDo(print()).andExpect(status().isOk());//.andExpect(jsonPath("$.firstName").value("Billy"));
        } catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
    }

    @Test
    @Order(3)
    @Sql({"/testData.sql"})
    public void readUserTestAll(){
        try{
            mockMvc.perform(get("/users/")).andDo(print()).andExpect(status().isOk());
        } catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
    }

    @Test
    @Order((4))
    public void updateUserTest(){
        try{
            mockMvc.perform(post("/update-user/").content(mapper.writeValueAsString(
                    new User(1,"Billy","Bob", "bb@email.com","555-000-0000"))).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk()).andExpect(jsonPath("$.phone").value("555-000-0000")).andDo(print());
        } catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
    }

    @Test
    @Order(5)
    public void deleteUserTestIndividual(){
        try{
            mockMvc.perform(post("/delete-user/1")).andExpect(status().isOk()).andExpect(jsonPath("$.firstName").value("Billy")).andDo(print());
        } catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
        try{
            mockMvc.perform(get("/user/1")).andDo(print());//.andExpect(jsonPath("$.firstName").value("Billy"));
        } catch (Exception e) {
            Assert.isInstanceOf(NestedServletException.class, e);
        }
    }

    @Test
    @Order(6)
    public void deleteUserTestAll(){
        try{
            mockMvc.perform(post("/delete-all-users/")).andDo(print()).andExpect(status().isOk()).andExpect(content().string("All users deleted"));
        } catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
        try{
            mockMvc.perform(get("/users/")).andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$").isEmpty());
        } catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
    }
}

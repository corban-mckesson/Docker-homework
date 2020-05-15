package com.corban.upskilling.homework.user.usercrud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createUserTest(){
        try{
            mockMvc.perform(put("/create-user/{USERDATA}")).andDo(print()).andExpect(status().isOk()).andExpect(content().string("user created"));
        } catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
    }

    @Test
    public void readUserTestIndividualFirstName(){
        try{
            mockMvc.perform(get("/find-user-first-name/{FIRSTNAME}")).andDo(print()).andExpect(status().isOk()).andExpect(content().string("USERDATA"));
        } catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
    }

    @Test
    public void readUserTestIndividualId(){
        try{
            mockMvc.perform(get("/find-user-first-name/{Id}")).andDo(print()).andExpect(status().isOk()).andExpect(content().string("USERDATA"));
        } catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
    }

    @Test
    public void readUserTestAll(){
        try{
            mockMvc.perform(get("/find-users")).andDo(print()).andExpect(status().isOk()).andExpect(content().string("ALLUSERDATA"));
        } catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
    }

    @Test
    public void updateUserTest(){
        try{
            mockMvc.perform(post("/update-user/{USERDATA}")).andDo(print()).andExpect(status().isOk()).andExpect(content().string("UPDTED USERDATA"));
        } catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
    }

    @Test
    public void deleteUserTestIndividual(){
        try{
            mockMvc.perform(post("/delete-user-first-name/{Id}")).andDo(print()).andExpect(status().isOk()).andExpect(content().string("user deleted"));
        } catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
    }

    @Test
    public void deleteUserTestAll(){
        try{
            mockMvc.perform(post("/delete-users/{USERDATA}")).andDo(print()).andExpect(status().isOk()).andExpect(content().string("All users deleted"));
        } catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
    }
}

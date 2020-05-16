package com.corban.upskilling.homework.user.usercrud.controller;

import com.corban.upskilling.homework.user.usercrud.model.User;
import com.corban.upskilling.homework.user.usercrud.services.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class userController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(){ return "Time for some users!"; }

    @PutMapping("/create-user/")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/user/{id}")
    public User findSingleUserByFirstName(@PathVariable("id") long id){
        return userService.findUserbyId(id);
    }

    @GetMapping("/users/")
    public List<User> findAllUsers(){
        return userService.findAll();
    }

    @PostMapping("/update-user/")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @PostMapping("/delete-user/{id}")
    public User deleteIndividualId(@PathVariable("id") long id){
        return userService.deleteIndividualId(id);
    }

    @PostMapping("delete-all-users/")
    public String deleteAllUsers(){
        return userService.deleteAllUsers();
    }
}

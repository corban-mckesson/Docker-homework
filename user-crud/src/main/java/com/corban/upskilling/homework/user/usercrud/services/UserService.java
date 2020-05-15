package com.corban.upskilling.homework.user.usercrud.services;

import com.corban.upskilling.homework.user.usercrud.model.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public String createUser(JSONObject user){
        User newUser = new User(user);
        userRepo.save(newUser);
        return "user created";
    }

    public String findUserByFirstName(String firstName){
        List<User> foundUsers = userRepo.findByFirstName(firstName);
        return foundUsers.toString();
    }

    public String findUserbyId(Long id){
        User foundUser = userRepo.findById(id).get();
        return foundUser.toString();
    }

    public String findAll(){
        List<User> foundUsers =(List<User>) userRepo.findAll();
        return foundUsers.toString();
    }

    public String updateUser(JSONObject user){
        User updatedUser = new User(user);
//        User olduser = userRepo.findById(updatedUser.getId()).get();
//        olduser = updatedUser;
        userRepo.save(updatedUser);
        return userRepo.findById(updatedUser.getId()).get().toString();
    }

    public String deleteIndividualId(Long id){
        User todelete = userRepo.findById(id).get();
        userRepo.delete(todelete);
        return "user deleted";
    }

    public String deleteAllUsers(){
        userRepo.deleteAll();
        return "All users deleted";
    }

}

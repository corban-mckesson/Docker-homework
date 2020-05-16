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

    public User createUser(User user){
        userRepo.save(user);
        return user;
    }

    public User findUserbyId(Long id){
        User foundUser = userRepo.findById(id).get();
        return foundUser;
    }

    public List<User> findAll(){
        List<User> foundUsers =(List<User>) userRepo.findAll();
        return foundUsers;
    }

    public User updateUser(User user){
        userRepo.save(user);
        return userRepo.findById(user.getId()).get();
    }

    public User deleteIndividualId(Long id){
        User todelete = userRepo.findById(id).get();
        userRepo.delete(todelete);
        return todelete;
    }

    public String deleteAllUsers(){
        userRepo.deleteAll();
        return "All users deleted";
    }

}

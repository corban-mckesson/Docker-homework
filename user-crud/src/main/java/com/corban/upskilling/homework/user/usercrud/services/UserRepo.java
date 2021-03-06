package com.corban.upskilling.homework.user.usercrud.services;

import com.corban.upskilling.homework.user.usercrud.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    List<User> findByFirstName(String firstName);
}

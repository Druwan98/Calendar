package com.example.projectCalendar.service;

import com.example.projectCalendar.model.Calendar;
import com.example.projectCalendar.model.User;
import com.example.projectCalendar.repository.RepoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServUser {
    @Autowired
    RepoUser repoUser;

    public List<User> viewAllUser(){
        return repoUser.findAll();
    }
    public void addUser(User user){
        repoUser.save(user);
    }
    public void deleteUser(long id){
        repoUser.deleteById(id);
    }
}

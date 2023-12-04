package com.example.projectCalendar.service;

import com.example.projectCalendar.model.Calendar;
import com.example.projectCalendar.model.Event;
import com.example.projectCalendar.model.User;
import com.example.projectCalendar.repository.RepoCalendar;
import com.example.projectCalendar.repository.RepoUser;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ServCalendar {
    @Autowired
    RepoCalendar repoCalendar;
    @Autowired
    RepoUser repoUser;

    public Calendar createCalendar(int userID, Calendar calendar) throws Exception{
        if (repoUser.findById(userID).isPresent()){
            User user = repoUser.findById(userID).orElse(null);

            calendar.setUser(user);

        } else {
            throw new Exception(String.format("User with ID %s not exist", userID));
        }

        return repoCalendar.save(calendar);
    }

    public List<Calendar> viewAllCalendarByUserID(int userID) throws Exception{
        Optional<User> user = repoUser.findById(userID);

        if (user.isPresent()) {
            return new ArrayList<>(user.get().getCalendars());
        } else {
            throw new Exception(String.format("User with ID %s don't have calendars", userID));
        }
    }


    public Calendar updateCalendar(int id, Calendar updateCalendar) throws Exception{
        if (repoCalendar.findById(id).isPresent()){

            Calendar calendar = repoCalendar.findById(id).get();

            if (Objects.nonNull(updateCalendar.getName())){
                calendar.setName(updateCalendar.getName());
            }

            if (Objects.nonNull(updateCalendar.getDescription())){
                calendar.setDescription(updateCalendar.getDescription());
            }

            return repoCalendar.save(calendar);
        } else {
            throw new Exception(String.format("Calendar with ID %s not found", id));
        }
    }


    public String deleteCalendar(int id) throws Exception{
        if (repoCalendar.findById(id).isPresent()){
            repoCalendar.deleteById(id);
            return String.format("Calendar with ID %s deleted", id);
        } else {
            throw new Exception(String.format("Calendar with ID %s not exist", id));
        }
    }


}

package com.example.projectCalendar.controller;

import com.example.projectCalendar.model.Calendar;
import com.example.projectCalendar.model.User;
import com.example.projectCalendar.service.ServCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/calendar")
public class ContrCalendar {
    @Autowired
    ServCalendar servCalendar;

    @GetMapping("/viewall")
    public List<Calendar> calendars() {
        return servCalendar.viewAllCalendar();
    }

    @GetMapping("/view/{id}")
    public Optional<Calendar> viewUserByID(@PathVariable long id) {
        return Optional.ofNullable(servCalendar.viewCalendar(id));
    }

    @PostMapping("/create/{id}")
    public String createNewCalendar(@RequestBody Calendar calendar, @PathVariable long id) {
        servCalendar.addCalendar(calendar);
        return "new Calendar created.";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCalendarById(@PathVariable long id) {
        servCalendar.deleteCalendar(id);
        return "Calendar id:" + id + "deleted";
    }

//    @PutMapping("update-calendar")
//    public String updateCalendar(@RequestParam long id, @RequestBody Calendar calendar){
//        servCalendar.updateCalendar(id, Optional.ofNullable(calendar.getUser()), Optional.ofNullable(calendar.getEvent()));
//        return "Calendar updated.";
//    }


}

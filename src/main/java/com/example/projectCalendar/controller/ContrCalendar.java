package com.example.projectCalendar.controller;

import com.example.projectCalendar.model.Calendar;
import com.example.projectCalendar.service.ServCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ContrCalendar {
    @Autowired
    ServCalendar servCalendar;

    @GetMapping("/view-all-calendar")
    public List<Calendar> calendars() {
        return servCalendar.viewAllCalendar();
    }

    @PostMapping("/create-new-calendar")
    public String createNewCalendar(@RequestBody Calendar calendar) {
        servCalendar.addCalendar(calendar);
        return "new Calendar created.";
    }

    @DeleteMapping("/delete-calendar-byid")
    public String deleteCalendarById(@RequestParam long id) {
        servCalendar.deleteCalendar(id);
        return "Calendar id:" + id + "deleted";
    }

//    @PutMapping("update-calendar")
//    public String updateCalendar(@RequestParam long id, @RequestBody Calendar calendar){
//        servCalendar.updateCalendar(id, Optional.ofNullable(calendar.getUser()), Optional.ofNullable(calendar.getEvent()));
//        return "Calendar updated.";
//    }


}

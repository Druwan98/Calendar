package com.example.projectCalendar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Calendar {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "calendar_id")
    @JsonIgnore
    private User user;
    @OneToMany(mappedBy = "calendar", cascade = CascadeType.ALL)
    private List<Event> event;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Event> getEvent() {
        return event;
    }

    public void setEvent(List<Event> event) {
        this.event = event;
    }

    public Calendar() {
    }



}

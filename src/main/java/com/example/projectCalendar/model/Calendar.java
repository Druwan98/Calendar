package com.example.projectCalendar.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Calendar {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "calendar", cascade = CascadeType.ALL)
    private List<Event> event;

    public Calendar() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

}

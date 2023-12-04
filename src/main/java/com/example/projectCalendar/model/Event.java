package com.example.projectCalendar.model;

import com.example.projectCalendar.util.HandleType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Event {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String description;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime dateTimeStart;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime dateTimeEnd;
    private String location;
    @JsonIgnore
    private HandleType handleType;
    @JsonIgnore
    private Integer recurrenceInterval;
    @ManyToOne
    @JoinColumn(name = "calendar_id")
    @JsonIgnore
    private Calendar calendar;
    @ManyToMany(mappedBy = "events")
    @JsonIgnore
    private List<User> participants;

    public Event() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTimeStart() {
        return dateTimeStart;
    }

    public void setDateTimeStart(LocalDateTime dateTimeStart) {
        this.dateTimeStart = dateTimeStart;
    }

    public LocalDateTime getDateTimeEnd() {
        return dateTimeEnd;
    }

    public void setDateTimeEnd(LocalDateTime dateTimeEnd) {
        this.dateTimeEnd = dateTimeEnd;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public HandleType getHandleType() {
        return handleType;
    }

    public void setHandleType(HandleType handleType) {
        this.handleType = handleType;
    }

    public Integer getRecurrenceInterval() {
        return recurrenceInterval;
    }

    public void setRecurrenceInterval(Integer recurrenceInterval) {
        this.recurrenceInterval = recurrenceInterval;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }
}
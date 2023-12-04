package com.example.projectCalendar.util;

import com.example.projectCalendar.model.Event;
import java.time.LocalDateTime;



public class HandleManager {
    public void setRecurrenceTimeAndDuration(Event event, LocalDateTime startTime, int duration) {

        event.setDateTimeStart(startTime);
        event.setRecurrenceInterval(duration);

        switch (event.getHandleType()) {

            case DAILY:
                event.setDateTimeEnd(startTime.plusDays(duration));
                break;
            case WEEKLY:
                event.setDateTimeEnd(startTime.plusWeeks(duration));
                break;
            case MONTHLY:
                event.setDateTimeEnd(startTime.plusMonths(duration));
                break;
            case YEARLY:
                event.setDateTimeEnd(startTime.minusYears(duration));
                break;
        }

    }
}
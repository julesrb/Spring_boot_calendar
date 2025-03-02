package BackendCalendarEvents.controller;

import BackendCalendarEvents.entity.Event;

import java.time.LocalDate;

public class EventDTO {
    private String message;
    private String event;
    private LocalDate date;

    EventDTO(Event eventEntity) {
        this.date = eventEntity.getDate();
        this.event = eventEntity.getEvent();
    }

    public void addedSuccessfully() {
        setMessage("The event has been added!");
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

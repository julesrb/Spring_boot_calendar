package BackendCalendarEvents.event;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class Event  {
//     private int id;
    private String message;
    @NotBlank
    private String event;
    @NotNull
    private LocalDate date;
//    private Date EndDate;
//    private String Description;

    public Event() {}

    public void addedSuccessfully() {
        setMessage("The event has been added!");
    }

    public Event(String event, LocalDate date) {
        this.event = event;
        this.date = date;
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

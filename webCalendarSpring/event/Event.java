package webCalendarSpring.event;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Event {
    private int id;
    private String title;
    private LocalDate date;
//    private Date EndDate;
//    private String Description;


    public Event(String title, LocalDate date) {
        this.title = title;
        this.date = date;
    }
}

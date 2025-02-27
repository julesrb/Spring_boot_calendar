package webCalendarSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import webCalendarSpring.event.Event;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }

    @GetMapping
    public List<Event> hello() {
        return List.of(
                new Event(
                        "here",
                        LocalDate.of(2020, 2, 1)
                ));
    }
}

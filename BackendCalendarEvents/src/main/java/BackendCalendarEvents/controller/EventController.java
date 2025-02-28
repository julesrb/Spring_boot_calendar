package BackendCalendarEvents.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import BackendCalendarEvents.event.Event;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
public class EventController {

    private ConcurrentMap<String, String> eventList = new ConcurrentHashMap<>();

    @GetMapping("/event/today")
    public List<Event> hello() {
        return List.of();
    }

    @PostMapping("/event")
    public Event createEvent(@Valid @RequestBody Event event) {
        event.addedSuccessfully();
        return (event);
    }
}

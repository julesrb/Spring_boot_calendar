package BackendCalendarEvents.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import BackendCalendarEvents.entity.EntityEvent;
import BackendCalendarEvents.event.Event;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
public class EventController {

    private ConcurrentMap<String, String> eventList = new ConcurrentHashMap<>();

    @GetMapping("/event")
    public List<EntityEvent> allEvents() {
        List<EntityEvent> events = new ArrayList<>();
        events.add(new EntityEvent("one", LocalDate.of(1111, 11, 22)));
        events.add(new EntityEvent("one", LocalDate.of(2222, 11, 22)));
        return events;
    }

    @GetMapping("/event/today")
    public List<Event> todayEvent() {
        return List.of();
    }

    @PostMapping("/event")
    public Event createEvent(@Valid @RequestBody Event event) {
        event.addedSuccessfully();
        return (event);
    }
}

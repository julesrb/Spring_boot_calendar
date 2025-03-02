package BackendCalendarEvents.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import BackendCalendarEvents.entity.Event;
import BackendCalendarEvents.service.EventService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping("/event")
public class EventController {

    private ConcurrentMap<String, String> eventList = new ConcurrentHashMap<>();
    private final EventService service;

    public EventController(EventService eventService) {
        this.service = eventService;
    }

    @GetMapping
    public ResponseEntity<List<Event>> getEvents(
            @RequestParam(name = "start_time", required = false) LocalDate startDate,
            @RequestParam(name = "end_time", required = false) LocalDate endDate) {

        List<Event> events;
        if (startDate != null && endDate != null) {
            events = service.findAllEventInBetween(startDate, endDate);
        }
        else {
            events = service.findAll();
        }
        if (events.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(events);
    }

    @PostMapping
    public ResponseEntity<EventDTO> createEvent(@Valid @RequestBody Event event) {
        Event createdEvent = service.addEvent(event);
        EventDTO createdEventDTO = new EventDTO(createdEvent);
        createdEventDTO.addedSuccessfully();
        return ResponseEntity.ok(createdEventDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable("id") Long id) {
        Optional<Event> event = service.findEventById(id);
        if (event.isEmpty())
            throw new EventNotFound("The event doesn't exist!");
        return ResponseEntity.ok(event.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Event> delete(@PathVariable("id") Long id) {
        Optional<Event> event = service.delete(id);
        if (event.isEmpty())
            throw new EventNotFound("The event doesn't exist!");
        return ResponseEntity.ok(event.get());
    }

    @GetMapping("/today")
    public ResponseEntity<List<Event>> todayEvent() {
        List<Event> events = service.findToday();
        return ResponseEntity.ok(events);
    }
}

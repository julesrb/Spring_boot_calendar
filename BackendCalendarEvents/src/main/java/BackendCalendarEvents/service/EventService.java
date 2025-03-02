package BackendCalendarEvents.service;

import org.springframework.stereotype.Service;
import BackendCalendarEvents.entity.Event;
import BackendCalendarEvents.repository.EventRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository repository;

    public EventService(EventRepository eventRepository) {
        this.repository = eventRepository;
    }

    public Event addEvent(Event event) {
        return (Event) repository.save(event);
    }

    public List<Event> findAll() {
        return repository.findAll();
    }

    public List<Event> findToday() {
        return repository.findAllByDate(LocalDate.now());
    }

    public Optional<Event> findEventById(long id) {
        return repository.findById(id);
    }

    public Optional<Event> delete(long id) {
        Optional<Event> event = findEventById(id);
        repository.deleteById(id);
        return event;
    }

    public List<Event> findAllEventInBetween(LocalDate start, LocalDate end) {
        List<Event> events = repository.findAllByDateBetween(start, end);
        if (events.isEmpty())
            return findAll();
        return events;
    }

}

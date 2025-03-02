package BackendCalendarEvents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import BackendCalendarEvents.entity.Event;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByDate(LocalDate date);
    List<Event> findAllByDateBetween(LocalDate start, LocalDate end);
}

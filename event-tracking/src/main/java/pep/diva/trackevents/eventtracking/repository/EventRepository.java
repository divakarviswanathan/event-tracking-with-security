package pep.diva.trackevents.eventtracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pep.diva.trackevents.eventtracking.model.Event;

/**
 * @author divakar
 *
 */
public interface EventRepository extends JpaRepository<Event, Long> {
	List<Event> findEventByCreatedBy(String createdBy);
}

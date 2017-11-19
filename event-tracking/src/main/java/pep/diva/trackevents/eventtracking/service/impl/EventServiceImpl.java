package pep.diva.trackevents.eventtracking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pep.diva.trackevents.eventtracking.model.Event;
import pep.diva.trackevents.eventtracking.repository.EventRepository;
import pep.diva.trackevents.eventtracking.service.EventService;

/**
 * @author divakar
 *
 */
@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;

	@Override
	public void saveEvent(Event event) {
		eventRepository.save(event);
	}

	@Override
	public List<Event> getAllEventsByUser(String createdBy) {
		return eventRepository.findEventByCreatedBy(createdBy);
	}

	@Override
	public void removeEvent(long id) {
		eventRepository.delete(id);
	}


}

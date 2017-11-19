package pep.diva.trackevents.eventtracking.service;

import java.util.List;

import pep.diva.trackevents.eventtracking.model.Event;

/**
 * @author divakar
 *
 */
public interface EventService {

	public void saveEvent(Event event);

	public List<Event> getAllEventsByUser(String createdBy);

	public void removeEvent(long id);
}

package pep.diva.trackevents.eventtracking.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pep.diva.trackevents.eventtracking.model.Event;
import pep.diva.trackevents.eventtracking.service.EventService;

/**
 * @author divakar
 *
 */
@Controller
@RequestMapping("/events")
public class EventController {

	private Logger logger = LoggerFactory.getLogger(EventController.class);

	@Autowired
	private EventService eventService;

	@RequestMapping(value = "/addEventForm", method = RequestMethod.GET)
	public String addEvent(Principal principal) {
		logger.info("Entering addEvent");
		return "addevent";
	}

	@RequestMapping(value = "/viewEvents", method = RequestMethod.GET)
	public ModelAndView viewEvents(Principal principal) {
		logger.info("Entering viewevents");
		ModelAndView mv = new ModelAndView("viewevents");
		List<Event> events = eventService.getAllEventsByUser(principal.getName());
		mv.addObject("events", events);
		return mv;
	}

	@RequestMapping(value = "/addEvent", method = RequestMethod.POST)
	public String addEventSave(@ModelAttribute("eventForm") Event event, Model model, Principal principal) {
		logger.info("Entering addEventSave");
		if (StringUtils.isEmpty(event.getEventAbout()) || event.getEventDate() == null
				|| StringUtils.isEmpty(event.getEventDescription())) {
			model.addAttribute("error", "Please check the details entered.");
			return "redirect:/events/addEventForm";
		}

		event.setCreatedBy(principal.getName());
		eventService.saveEvent(event);
		return "redirect:/home";
	}

	@RequestMapping(value = "/removeEvent", method = RequestMethod.POST)
	public String removeEvent(HttpServletRequest request, HttpServletResponse response) {
		logger.info("Entering remove events");
		eventService.removeEvent(Long.parseLong(request.getParameter("eventid")));
		return "redirect:/events/viewEvents";
	}
}

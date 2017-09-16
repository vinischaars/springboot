package enf.eventos.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import enf.eventos.domain.Event;
import enf.eventos.service.EventsService;

@Controller
public class EventsController {
	
	@Autowired
	EventsService service;
	
	@RequestMapping(path="events", method=RequestMethod.GET)
	public ResponseEntity<List<Event>> listEvents() {
		
		return ResponseEntity.ok(service.findAll());
	}
	
}

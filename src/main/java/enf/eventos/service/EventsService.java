package enf.eventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enf.eventos.data.EventRepository;
import enf.eventos.domain.Event;

@Service
public class EventsService {
	
	@Autowired
	EventRepository repository;
	
	public List<Event> findAll() {
		return repository.findAll();
	}

}

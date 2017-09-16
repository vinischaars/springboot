package enf.eventos.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import enf.eventos.domain.Event;

@Repository
public class EventRepository {

	public List<Event> findAll() {
		
		List<Event> events = new ArrayList<Event>();
		
		events.add(new Event("Show 1", new Date()));
		events.add(new Event("Show 2", new Date()));
		
		return events;
	}

}

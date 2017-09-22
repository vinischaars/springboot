package enf.eventos.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import enf.eventos.domain.Evento;

@Repository
public class EventoRepository {

	public List<Evento> findAll() {
		
		List<Evento> events = new ArrayList<Evento>();
		
		events.add(new Evento("Show 1", new Date()));
		events.add(new Evento("Show 2", new Date()));
		
		return events;
	}

}

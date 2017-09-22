package enf.eventos.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import enf.eventos.domain.Evento;

@Repository
public class EventoRepository {

	@Autowired
	CommomRepository repository;
	
	public List<Evento> findAll() {
		
		List<Evento> eventos = new ArrayList<Evento>();
		
		eventos = repository.criarEventos();
		
		return eventos;
	}

}

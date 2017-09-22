package enf.eventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enf.eventos.data.EventoRepository;
import enf.eventos.domain.Evento;

@Service
public class EventosService {
	
	@Autowired
	EventoRepository repository;
	
	public List<Evento> findAll() {
		return repository.findAll();
	}

}

package enf.eventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enf.eventos.data.EventoRepository;
import enf.eventos.domain.Evento;

@Service
public class EventoService {
	
	@Autowired
	EventoRepository repository;
	
	public List<Evento> listar() {
		return repository.listar();
	}
	
	public Evento buscarPorId(long id){
		return repository.buscarPorId(id);
	}
	
	public List<Evento> buscarPorNome(String nome){
		return repository.buscarPorNome(nome);
	}
	
	public Evento criarEvento(Evento evento) {
		return repository.criarEvento(evento);
	}

}

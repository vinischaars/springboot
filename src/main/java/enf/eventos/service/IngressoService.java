package enf.eventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enf.eventos.data.IngressoRepository;
import enf.eventos.domain.Ingresso;

@Service
public class IngressoService {

	@Autowired
	IngressoRepository repository;
	
	public List<Ingresso> findAll() {
		return repository.findAll();
	}
	
	public List<Ingresso> findByName(String tipoIngresso){
		return repository.findByName(tipoIngresso);
	}
	
	
}

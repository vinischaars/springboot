package enf.eventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enf.eventos.data.IngressoEventoRepository;
import enf.eventos.data.IngressoRepository;
import enf.eventos.domain.Ingresso;
import enf.eventos.domain.IngressoEvento;

@Service
public class IngressoEventoService {

	@Autowired
	IngressoEventoRepository repository;

	public List<IngressoEvento> findByEvent(int idEvento) {
		return repository.findByEvent(idEvento);
	}
	
	public List<IngressoEvento> adicionarIngressosEmEventos(IngressoEvento ingressoEvento){
		return repository.adicionarIngressosEmEventos(ingressoEvento);
	}
}

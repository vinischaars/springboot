package enf.eventos.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import enf.eventos.domain.Ingresso;
import enf.eventos.domain.IngressoEvento;
import enf.eventos.service.IngressoEventoService;
import enf.eventos.service.IngressoService;

@RestController
@RequestMapping("/eventos/{idEvento}/ingressos")
public class IngressosEventoController {

	@Autowired
	IngressoEventoService service;

	@GetMapping
	public ResponseEntity<List<IngressoEvento>> listaIngressosDoEvento(@PathVariable int idEvento) {
		return ResponseEntity.ok(service.findByEvent(idEvento));
	}
	
	@PostMapping
	public ResponseEntity<List<IngressoEvento>> adicionaIngressosEmEventos(@RequestBody IngressoEvento ingressoEvento){
		return ResponseEntity.ok(service.adicionarIngressosEmEventos(ingressoEvento));
	}
	
}

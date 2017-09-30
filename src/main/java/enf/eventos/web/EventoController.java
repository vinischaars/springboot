package enf.eventos.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import enf.eventos.domain.Evento;
import enf.eventos.service.EventoService;

@RestController
@RequestMapping("/eventos")
public class EventoController {
	
	@Autowired
	EventoService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Evento>> listar() {
		return new ResponseEntity<>(service.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/buscar/{id}")
	public ResponseEntity<Evento> buscarPorId(@PathVariable long id) {
		Evento evento = service.buscarPorId(id);
		if (evento != null) {
			return new ResponseEntity<>(evento, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/buscar")
	public ResponseEntity<Evento> buscarPorNome(@RequestParam String nome) {
		List<Evento> evento = service.buscarPorNome(nome);
		if (evento != null) {
			return new ResponseEntity(evento, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> criarEvento(@RequestBody Evento evento){
		return ResponseEntity.ok(service.criarEvento(evento));
	}
		
}

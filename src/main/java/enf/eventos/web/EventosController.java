package enf.eventos.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import enf.eventos.domain.Evento;
import enf.eventos.service.EventosService;

@RestController
@RequestMapping("/events")
public class EventosController {
	
	@Autowired
	EventosService service;
	
	@GetMapping
	public ResponseEntity<List<Evento>> listEvents(@RequestParam(value="name", defaultValue="All") String name) {
		System.out.println("Teste");
		if(name.equals("All")) {
			return ResponseEntity.ok(service.findAll());
		} else
			return ResponseEntity.ok(service.findByName(name));
	}
	
	@PostMapping
	public ResponseEntity<Evento> criarEvento(@RequestBody Evento evento){
		return ResponseEntity.ok(service.criarEvento(evento));
	}
		
}

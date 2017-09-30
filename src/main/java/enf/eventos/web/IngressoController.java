package enf.eventos.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import enf.eventos.domain.Ingresso;
import enf.eventos.service.IngressoService;

@RestController
@RequestMapping("/ingressos")
public class IngressoController {

	@Autowired
	IngressoService service;
	
	@GetMapping
	public ResponseEntity<List<Ingresso>> listaIngressos(@RequestParam(value="id", defaultValue="All") String idIngresso) {
		if(idIngresso.equals("All")) {
			return ResponseEntity.ok(service.findAll());
		} else
			return ResponseEntity.ok(service.findById(idIngresso));
	}
	
}

package enf.eventos.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngressoEvento {
	
	private Long id;
	private Evento evento;
	private Ingresso ingresso;
	private Date inicioVenda;
	private Date finalVenda;

}

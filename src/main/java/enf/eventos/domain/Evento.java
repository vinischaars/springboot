package enf.eventos.domain;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evento {

    private Long id;
	
	@NotNull(message="O nome do evento é obrigatório")
	@Size(max=150, message="O nome permite no máximo 150 caracteres")
	private String name;

	@NotNull(message="A data do evento é obrigatória")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd", locale = "pt-BR", timezone = "Brazil/East")
	@Future(message="A data do evento deve ser igual ou maior que a de hoje")
	private Date date;
		
}

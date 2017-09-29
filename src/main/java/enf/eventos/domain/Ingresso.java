package enf.eventos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingresso {

    private Long id;
    
    private String tipoIngresso;
    private Double valorIngresso;
	
}

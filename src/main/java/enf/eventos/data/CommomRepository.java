package enf.eventos.data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import lombok.*;

import org.springframework.stereotype.Repository;

import enf.eventos.domain.Evento;

@Repository
public class CommomRepository {
	
	public List<Evento> criarEventos(){
		
		List<Evento> eventos = new ArrayList<Evento>();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date();

		Evento teste = new Evento(new Long(1),"Bon Jovi", data);
		eventos.add(teste);
		
		/*try {
			
			data = df.parse("19/09/2017");
			eventos.add(new Evento("Bon Jovi",data));
			data = df.parse("26/10/2017");		
			eventos.add(new Evento("The Who",data));
			data = df.parse("13/10/2017");		
			eventos.add(new Evento("Paul McCartney",data));
			data = df.parse("20/10/2017");		
			eventos.add(new Evento("Green Day",data));
			data = df.parse("18/01/2018");		
			eventos.add(new Evento("Foo Fighters",data));
		} catch (ParseException e) {
			e.printStackTrace();
		}	*/
		
		return eventos;
	}
	
	public Evento criarEvento(Evento evento){

		return new Evento(new Long(1),evento.getName(),evento.getDate());
		
	}
	
}

package enf.eventos.domain;

import java.util.Date;

public class Evento {
	private String name;
	private Date date;
	private Date dataInicioVenda;
	private Date dataFinalVenda;
	
	public Evento() {}
	
	public Evento(String name, Date date) {
		this.name = name;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}

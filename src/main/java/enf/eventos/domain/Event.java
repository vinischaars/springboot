package enf.eventos.domain;

import java.util.Date;

public class Event {
	private String name;
	private Date date;
	
	public Event() {}
	
	public Event(String name, Date date) {
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

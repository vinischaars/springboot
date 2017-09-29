package enf.eventos.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ch.qos.logback.core.net.SyslogOutputStream;
import enf.eventos.domain.Evento;

@Repository
public class EventoRepository {

	@Autowired
	CommomRepository repository;
	
	@Autowired
	NamedParameterJdbcTemplate jdbc;
	
	public List<Evento> findAll() {

		String sql = "select * from evento";

		List<Evento> eventos = jdbc.query(sql, new RowMapper<Evento>(){

			@Override
			public Evento mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Evento(
						rs.getLong("id_evento"), 
						rs.getString("nome_evento"), 
						rs.getDate("data_evento"));
			}
		});

		//eventos = repository.criarEventos();
		
		return eventos;
	}
	
	public List<Evento> findByName(String name){

		List<Evento> eventos = new ArrayList<Evento>();
		
		//eventos = repository.criarEvento(name);
		
		return eventos;
		
	}
	
	public Evento criarEvento(Evento evento){

		String sql = "insert into evento (nome_evento, data_evento) values (:nome, :data)";
		System.out.println(sql);
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("nome", evento.getName());
		params.put("data", evento.getDate());
		
		jdbc.update(sql, params);
		
		System.out.println(evento.getName());
		System.out.println(evento.getDate());
		
		String selectSql = "select * from evento where nome_evento = :nome and data_evento = :data";
		System.out.println(selectSql);
				
		Evento eventoCriado = jdbc.queryForObject(selectSql, params, new RowMapper<Evento>() {
			@Override
			public Evento mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Evento(
						rs.getLong("id_evento"), 
						rs.getString("nome_evento"), 
						rs.getDate("data_evento"));
			}
		});

		return eventoCriado;
		
		//return repository.criarEvento(evento); 
		
	}

}

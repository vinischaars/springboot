package enf.eventos.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import enf.eventos.domain.Evento;

@Repository
public class EventoRepository {

	@Autowired
	NamedParameterJdbcTemplate jdbc;
	
	public List<Evento> listar() {

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

		return eventos;
	}
	
	public Evento buscarPorId(long id){

		String sql = "select * from evento where id_evento = :id";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		Evento evento = jdbc.queryForObject(sql, params, new RowMapper<Evento>(){

			@Override
			public Evento mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Evento(
						rs.getLong("id_evento"), 
						rs.getString("nome_evento"), 
						rs.getDate("data_evento"));
			}
		});

		return evento;
		
	}

	public List<Evento> buscarPorNome(String nome){

		String sql = "select * from evento where nome_evento = :nome";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("nome", nome);

		List<Evento> eventos = jdbc.query(sql, params, new RowMapper<Evento>(){

			@Override
			public Evento mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Evento(
						rs.getLong("id_evento"), 
						rs.getString("nome_evento"), 
						rs.getDate("data_evento"));
			}
		});

		return eventos;
		
	}
	
	public Evento criarEvento(Evento evento){

		String sql = "insert into evento (nome_evento, data_evento) values (:nome, :data)";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("nome", evento.getName());
		params.put("data", evento.getDate());

		jdbc.update(sql, params);
		
		String selectSql = "select * from evento where nome_evento = :nome and data_evento = :data";

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
				
	}

}

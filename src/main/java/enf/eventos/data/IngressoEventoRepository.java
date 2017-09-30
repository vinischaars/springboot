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
import enf.eventos.domain.Ingresso;
import enf.eventos.domain.IngressoEvento;
@Repository
public class IngressoEventoRepository {

	@Autowired
	NamedParameterJdbcTemplate jdbc;
	@Autowired
	EventoRepository eventoRepository;
	@Autowired
	IngressoRepository ingressoRepository;
	
	public List<IngressoEvento> findByEvent(int idEvento) {

		//String sql = "select * from ingresso_evento";
		String sql = "SELECT IE.ID_INGRESSO_EVENTO, E.ID_EVENTO, E.NOME_EVENTO, E.DATA_EVENTO, I.ID_INGRESSO, I.TIPO_INGRESSO, I.VALOR_INGRESSO, IE.INICIO_VENDA, IE.FINAL_VENDA FROM INGRESSO_EVENTO IE, EVENTO E, INGRESSO I WHERE E.ID_EVENTO = :id_evento AND IE.ID_EVENTO = E.ID_EVENTO AND I.ID_INGRESSO = IE.ID_INGRESSO";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id_evento", idEvento);

		List<IngressoEvento> ingressosEvento = jdbc.query(sql, params, new RowMapper<IngressoEvento>(){

			@Override
			public IngressoEvento mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new IngressoEvento(
						rs.getLong("id_ingresso_evento"),
						new Evento(rs.getLong("id_evento"),rs.getString("nome_evento"),rs.getDate("data_evento")),
						new Ingresso(rs.getLong("id_ingresso"),rs.getString("tipo_ingresso"),rs.getDouble("valor_ingresso")),
						rs.getDate("inicio_venda"), 
						rs.getDate("final_venda"));
			}
		});

		return ingressosEvento;
	}
	
	public List<IngressoEvento> adicionarIngressosEmEventos(IngressoEvento ingressoEvento){

		String sql = "INSERT INTO INGRESSO_EVENTO(ID_EVENTO, ID_INGRESSO, INICIO_VENDA, FINAL_VENDA) VALUES (:id_evento, :id_ingresso, :inicio_venda, :final_venda)";
		
		//Evento evento = eventoRepository.findById(ingressoEvento.getEvento().getId().toString()).get(0);
		//Ingresso ingresso = ingressoRepository.findById(ingressoEvento.getIngresso().getId().toString()).get(0);	
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id_evento", ingressoEvento.getEvento().getId());
		params.put("id_ingresso", ingressoEvento.getIngresso().getId());
		params.put("inicio_venda", ingressoEvento.getInicioVenda());
		params.put("final_venda", ingressoEvento.getFinalVenda());

		jdbc.update(sql, params);

		String selectSql = "SELECT IE.ID_INGRESSO_EVENTO, E.ID_EVENTO, E.NOME_EVENTO, E.DATA_EVENTO, I.ID_INGRESSO, I.TIPO_INGRESSO, I.VALOR_INGRESSO, IE.INICIO_VENDA, IE.FINAL_VENDA FROM INGRESSO_EVENTO IE, EVENTO E, INGRESSO I WHERE IE.ID_EVENTO = :id_evento AND IE.ID_INGRESSO = :id_ingresso AND IE.ID_EVENTO = E.ID_EVENTO AND I.ID_INGRESSO = IE.ID_INGRESSO";

		List<IngressoEvento> ingressoAdicionado = jdbc.query(selectSql, params, new RowMapper<IngressoEvento>() {
			@Override
			public IngressoEvento mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new IngressoEvento(
						rs.getLong("id_ingresso_evento"),
						new Evento(rs.getLong("id_evento"),rs.getString("nome_evento"),rs.getDate("data_evento")),
						new Ingresso(rs.getLong("id_ingresso"),rs.getString("tipo_ingresso"),rs.getDouble("valor_ingresso")),
						rs.getDate("inicio_venda"), 
						rs.getDate("final_venda"));
			}
		});

		return ingressoAdicionado;
	}
	
}

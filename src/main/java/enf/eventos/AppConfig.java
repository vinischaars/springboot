package enf.eventos;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class AppConfig {

	@Autowired
	DataSource dataSource;

	@Bean
	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource);
	}

}
package com.dacg.api.pokedex.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class ConfigDataSource {

	@Bean(name = "apiPokemon")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource masterDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "jdbcTemplate")
	@Autowired
	public JdbcTemplate mainJdbcTemplate(@Qualifier("apiPokemon") DataSource apiPokemon) {
		return new JdbcTemplate(apiPokemon);
	}

	@Primary
	@Bean(name = "namedJdbcTemplate")
	@Autowired
	public NamedParameterJdbcTemplate mainNamedParameterJdbcTemplate(@Qualifier("apiPokemon") DataSource gestionUsuariosDs) {
		return new NamedParameterJdbcTemplate(gestionUsuariosDs);
	}
}

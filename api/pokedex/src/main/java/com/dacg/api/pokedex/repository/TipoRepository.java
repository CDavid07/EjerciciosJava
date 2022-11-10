package com.dacg.api.pokedex.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dacg.api.pokedex.modelo.TipoModel;

@Repository
public class TipoRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void save(TipoModel entity) {
		String sqlStament = "insert into typePokemon (name) values (?);";
		jdbcTemplate.update(sqlStament, new Object[]{entity.getName()});
	}
 
	public void remove(int id) {
		String sqlStament = "delete from typePokemon where name = ?";
		jdbcTemplate.update(sqlStament, new Object[]{id});
	}
}

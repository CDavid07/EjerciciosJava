package com.dacg.api.pokedex.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dacg.api.pokedex.modelo.TargetPokemonModel;

@Repository
public class TargetPokemonRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void save(TargetPokemonModel entity) {
		String sqlStament = "insert into target_pokemon (user_id, pokemon_id, defense, attack) values (?, ?, ?, ?);";
		jdbcTemplate.update(sqlStament, new Object[]{entity.getUser_id(),entity.getPokemon_id(),
				entity.getDefense(), entity.getAttack()});
	}
 
	public void remove(int id) {
		String sqlStament = "delete from target_pokemon where pokemon_id = ?";
		jdbcTemplate.update(sqlStament, new Object[]{id});
	}
}

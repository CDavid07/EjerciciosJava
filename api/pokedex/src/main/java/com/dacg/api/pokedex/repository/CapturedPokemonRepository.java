package com.dacg.api.pokedex.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dacg.api.pokedex.modelo.CapturedPokemonModel;

@Repository
public class CapturedPokemonRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier("namedJdbcTemplate")
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public List<CapturedPokemonModel> getByIdUsuario(int id){
		String sql = "select * from pokemon_record where user_id = :id";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		
		return namedJdbcTemplate.query(sql, params, (rs, rowNum) -> CapturedPokemonModel.builder()
				
				.user_id(rs.getInt("user_id"))
				.pokemon_id(rs.getInt("pokemon_id"))
				.defense(rs.getInt("defense"))
				.attack(rs.getInt("attack")).build());
				
	}
	
	
	public void save(CapturedPokemonModel entity) {
		String sqlStament = "insert into captured_pokemon (user_id, pokemon_id, defense , attack) values (?, ?, ?, ?);";
		jdbcTemplate.update(sqlStament, new Object[]{entity.getUser_id(),entity.getPokemon_id(),
				entity.getDefense(), entity.getAttack()});
	}

	public void remove(int id) {
		String sqlStament = "delete from captured_pokemon where id = ?";
		jdbcTemplate.update(sqlStament, new Object[]{id});
	}
}

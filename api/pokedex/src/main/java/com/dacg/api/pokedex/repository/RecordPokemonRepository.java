package com.dacg.api.pokedex.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dacg.api.pokedex.modelo.RecordPokemonModel;

@Repository
public class RecordPokemonRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier("namedJdbcTemplate")
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public List<RecordPokemonModel> getByIdUsuario(int id){
		String sql = "select * from pokemon_record where user_id = :id";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		
		return namedJdbcTemplate.query(sql, params, (rs, rowNum) -> RecordPokemonModel.builder()
				
				.user_id(rs.getInt("user_id"))
				.pokemon_id(rs.getInt("pokemon_id"))
				.seen(rs.getInt("seen"))
				.captured(rs.getInt("captured"))
				.skiped(rs.getInt("skiped")).build());
				
	}
	
	public void save(RecordPokemonModel entity) {
		String sqlStament = "insert into pokemon_record (user_id, pokemon_id, seen, captured, skiped ) values (?, ?, ?, ?, ?);";
		jdbcTemplate.update(sqlStament, new Object[]{entity.getUser_id(),entity.getPokemon_id(),
				entity.getSeen(), entity.getCaptured(), entity.getSkiped()});
	}
 
	public void remove(int id) {
		String sqlStament = "delete from pokemon_record where pokemon_id = ?";
		jdbcTemplate.update(sqlStament, new Object[]{id});
	}
}

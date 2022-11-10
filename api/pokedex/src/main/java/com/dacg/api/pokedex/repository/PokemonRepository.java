package com.dacg.api.pokedex.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dacg.api.pokedex.modelo.PokemonModel;

@Repository
public class PokemonRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier("namedJdbcTemplate")
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public PokemonModel getPokemon(String nombre){
		String sql = "select * from pokemon where nombre = :name ";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", nombre);
		
		return namedJdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> PokemonModel.builder()
				.id(rs.getInt("id"))
				.nombre(rs.getString("nombre"))
				.sprite(rs.getString("sprite"))
				.type_id(rs.getInt("type_id"))
				.second_type_id(rs.getInt("second_type_id")).build());
				
	}
	
	public void save(PokemonModel entity) {
		String sqlStament = "insert into pokemon (nombre, sprite, type_id , second_type_id ) values (?, ?, ?, ?);";
		jdbcTemplate.update(sqlStament, new Object[]{entity.getNombre(),entity.getSprite(),
				entity.getType_id(), entity.getSecond_type_id()});
	}
 
	public void remove(int id) {
		String sqlStament = "delete from pokemon where id = ?";
		jdbcTemplate.update(sqlStament, new Object[]{id});
	}
}

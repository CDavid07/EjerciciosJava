package com.dacg.api.pokedex.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dacg.api.pokedex.modelo.UserModel;

@Repository
public class UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier("namedJdbcTemplate")
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public UserModel getUsuario(String nombre){
		String sql = "select * from usuario where username = :name ";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", nombre);
		
		return namedJdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> UserModel.builder()
				.id(rs.getInt("id"))
				.username(rs.getString("username"))
				.password(rs.getString("password")).build());
				
	}
	
	public void save(UserModel entity) {
		String sqlStament = "insert into usuario (username, password) values (?, ?);";
		jdbcTemplate.update(sqlStament, new Object[]{entity.getUsername(),entity.getPassword()});
	}
 
	public void remove(int id) {
		String sqlStament = "delete from usuario where id = ?";
		jdbcTemplate.update(sqlStament, new Object[]{id});
	}
}

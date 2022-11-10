package com.dacg.api.pokedex.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PokemonModel {

	private int id;
	private String nombre; 
	private String sprite;
	private int type_id;
	private int second_type_id;
}

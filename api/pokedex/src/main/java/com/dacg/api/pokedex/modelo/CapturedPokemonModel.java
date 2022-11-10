package com.dacg.api.pokedex.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CapturedPokemonModel {

	private int user_id;  
	private int pokemon_id;
	private int defense; 
	private int attack;
}

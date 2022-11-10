package com.dacg.api.pokedex.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dacg.api.pokedex.modelo.PokemonModel;
import com.dacg.api.pokedex.modelo.RecordPokemonModel;
import com.dacg.api.pokedex.repository.PokemonRepository;
import com.dacg.api.pokedex.repository.RecordPokemonRepository;

@Service
public class BuscarPokemonService {

	@Autowired
	private PokemonRepository pokemonRepository;
	
	@Autowired
	private RecordPokemonRepository recordRepository;
		

	public PokemonModel getPokemon(String name) {
		return pokemonRepository.getPokemon(name);
	}

	public void guardarPokemon(PokemonModel pokemon, int id) {
		
		//guardamos pokemon
		pokemonRepository.save(pokemon);
		
		//Registramos a pokemon que buscamos
		RecordPokemonModel nuevo = new RecordPokemonModel(id,pokemon.getId(),1,0,0);
		recordRepository.save(nuevo);
	}

	
}

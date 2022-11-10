package com.dacg.api.pokedex.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dacg.api.pokedex.modelo.CapturedPokemonModel;
import com.dacg.api.pokedex.modelo.PokemonModel;
import com.dacg.api.pokedex.modelo.RecordPokemonModel;
import com.dacg.api.pokedex.repository.CapturedPokemonRepository;
import com.dacg.api.pokedex.repository.PokemonRepository;
import com.dacg.api.pokedex.repository.RecordPokemonRepository;

@Service
public class CapturarPokemonService {

	@Autowired
	private PokemonRepository pokemonRepository;
	
	@Autowired
	private RecordPokemonRepository recordRepository;
	
	@Autowired
	private CapturedPokemonRepository capturedRepository;
	
	public void guardarPokemon(PokemonModel pokemon, int id) {
		try {
			//Verificamos si el pokemon esta guardado
			PokemonModel buscar = this.pokemonRepository.getPokemon(pokemon.getNombre());
			if(buscar == null) {
				this.pokemonRepository.save(pokemon);
				
				//Registramos a pokemon que buscamos
				RecordPokemonModel nuevo = new RecordPokemonModel(id,pokemon.getId(),1,1,0);
				recordRepository.save(nuevo);
				
				//Registramos pokemon capturado
				CapturedPokemonModel nuevoC = new CapturedPokemonModel(id,pokemon.getId(),0,0);
				capturedRepository.save(nuevoC);
			}else {
				//Registramos pokemon capturado
				CapturedPokemonModel nuevoC = new CapturedPokemonModel(id,pokemon.getId(),0,0);
				capturedRepository.save(nuevoC);
			}
			
		} catch (Exception ex) {
			ex.getMessage();
		}
	}
}

package com.dacg.api.pokedex.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dacg.api.pokedex.modelo.CapturedPokemonModel;
import com.dacg.api.pokedex.modelo.RecordPokemonModel;
import com.dacg.api.pokedex.repository.CapturedPokemonRepository;
import com.dacg.api.pokedex.repository.PokemonRepository;
import com.dacg.api.pokedex.repository.RecordPokemonRepository;

@Service
public class ListarPokemonService {

	@Autowired
	private CapturedPokemonRepository capturePokemonRepository;
	
	@Autowired
	private RecordPokemonRepository recordPokemonRepository;
	
	@Autowired
	private PokemonRepository pokemonRepository;	

	public List<RecordPokemonModel> getAllPokemonRecord(int id) {
		return recordPokemonRepository.getByIdUsuario(id);
	}
	
	public List<CapturedPokemonModel> getAllPokemonCaptured(int id) {
		return capturePokemonRepository.getByIdUsuario(id);
	}

	public void eliminarPokemon(int id) {
		//eliminar de capturado
		recordPokemonRepository.remove(id);
	}

}

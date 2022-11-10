package com.dacg.api.pokedex.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dacg.api.pokedex.repository.TargetPokemonRepository;

@Service
public class EscaparPokemonService {

	@Autowired
	private TargetPokemonRepository targetRepository;

	public void eliminarTarget(int id) {
		targetRepository.remove(id);
	}
}

package com.dacg.api.pokedex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dacg.api.pokedex.modelo.PokemonModel;
import com.dacg.api.pokedex.servicios.CapturarPokemonService;

@RestController
@RequestMapping("/capturar")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })
public class CapturarPokemonController {

	@Autowired
	private CapturarPokemonService capturarService;
	
	@PostMapping(path = "{id}")
	public void guardarPokemon(@RequestBody PokemonModel pokemon, @PathVariable("id") int id) {
		try {
			this.capturarService.guardarPokemon(pokemon, id);
		} catch (Exception ex) {
			ex.getMessage();
		}
	}
}

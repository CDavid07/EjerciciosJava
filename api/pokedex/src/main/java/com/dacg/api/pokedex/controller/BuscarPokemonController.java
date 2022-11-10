package com.dacg.api.pokedex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.dacg.api.pokedex.modelo.PokemonModel;
import com.dacg.api.pokedex.servicios.BuscarPokemonService;

@RestController
@RequestMapping("/buscar")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class BuscarPokemonController {

	@Autowired
	private BuscarPokemonService buscarService;

	@GetMapping(path = "/{id}")
	public ResponseEntity<PokemonModel> obtenerPokemonPorId(@PathVariable("id") String id) {
		PokemonModel pokemon = null;
		try {
			pokemon = this.buscarService.getPokemon(id);
		} catch (Exception ex) {
			ex.getMessage();
		}
		return ResponseEntity.status(HttpStatus.OK).body(pokemon);

	}

	@PostMapping(path = "/pokemon/{id}")
	public void guardarPokemon(@RequestBody PokemonModel pokemon, @PathVariable("id") int id) {
		try {
			this.buscarService.guardarPokemon(pokemon, id);
		} catch (Exception ex) {
			ex.getMessage();
		}
	}

}

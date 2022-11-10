package com.dacg.api.pokedex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dacg.api.pokedex.servicios.EscaparPokemonService;

@RestController
@RequestMapping("/escapar")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })
public class EscaparPokemonController {

	@Autowired
	private EscaparPokemonService escaparService;

	@DeleteMapping(path = "/{id}")
	public void eliminar(@PathVariable int id) {
		try {
			this.escaparService.eliminarTarget(id);
		} catch (Exception ex) {
			ex.getMessage();
		}
	}
}

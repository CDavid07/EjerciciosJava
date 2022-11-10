package com.dacg.api.pokedex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dacg.api.pokedex.modelo.CapturedPokemonModel;
import com.dacg.api.pokedex.modelo.RecordPokemonModel;
import com.dacg.api.pokedex.servicios.ListarPokemonService;

@RestController
@RequestMapping("/lista")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })
public class ListarPokemonController {

	@Autowired
	private ListarPokemonService listarService;
	
	@GetMapping(path = "/record/{id}")
	public ResponseEntity<List<RecordPokemonModel>> obtenerRecordPokemon(@PathVariable("id") int id) {
		List<RecordPokemonModel> recordPokemon = null;
		try {
			recordPokemon = this.listarService.getAllPokemonRecord(id);
		}catch(Exception ex) {
			ex.getMessage();
		}
		return ResponseEntity.status(HttpStatus.OK).body(recordPokemon);
	}
	
	@GetMapping(path = "/capturados/{id}")
	public ResponseEntity<List<CapturedPokemonModel>> obtenerCapturedPokemon(@PathVariable("id") int id) {
		List<CapturedPokemonModel> capturedPokemon = null;
		try {
			capturedPokemon = this.listarService.getAllPokemonCaptured(id);
		}catch(Exception ex) {
			ex.getMessage();
		}
		return ResponseEntity.status(HttpStatus.OK).body(capturedPokemon);
	}
	
	
	@DeleteMapping(path = "/eliminar/{id}") 
	public void eliminar(@PathVariable int id) {
		try {
			this.listarService.eliminarPokemon(id);
		} catch (Exception ex) {
			ex.getMessage();
		}
	}
}

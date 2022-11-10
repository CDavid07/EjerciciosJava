package com.dacg.api.pokedex.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dacg.api.pokedex.modelo.UserModel;
import com.dacg.api.pokedex.servicios.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })
public class UsuarioController {

	/**
	 * @Autowired UsuarioService usuarioService; BCryptPasswordEncoder
	 *            bCryptPasswordEncoder;
	 */

	private final UsuarioService usuarioService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public UsuarioController(@Autowired UsuarioService usuarioService,
			@Autowired BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.usuarioService = usuarioService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserModel> buscarUsuario(@RequestBody UserModel usuario) {
		UserModel user=null;
		try {
			user = usuarioService.getUsuario(usuario);
		} catch (Exception ex) {
			ex.getMessage();
		}
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	@PostMapping()
	public ResponseEntity<UserModel> guardarUsuario(@RequestBody UserModel usuario) {
		
		UserModel user=null;
		//cifrar contraseña
		usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
		try {
			user = usuarioService.guardarUsuario(usuario);
		} catch (Exception ex) {
			ex.getMessage();
		}
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	// Eliminar usuario
	@DeleteMapping("/eliminar/{id}")
	public void eliminarPorId(@PathVariable("id") int id) {
		 this.usuarioService.eliminarUsuario(id);
		
	}
}

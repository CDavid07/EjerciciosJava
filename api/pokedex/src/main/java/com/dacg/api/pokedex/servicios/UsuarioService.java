package com.dacg.api.pokedex.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dacg.api.pokedex.modelo.UserModel;
import com.dacg.api.pokedex.repository.UserRepository;

@Service
public class UsuarioService {

	@Autowired
	private UserRepository userRepository;

	public UserModel getUsuario(UserModel usuario) {
		return userRepository.getUsuario(usuario.getUsername());
	}

	public UserModel guardarUsuario(UserModel usuario) {
		userRepository.save(usuario);
		return usuario;
	}

	public void eliminarUsuario(int name) {
		userRepository.remove(name);
	}
}

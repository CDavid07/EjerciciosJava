package com.dacg.api.pokedex.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel {

	private int id;
	private String username;
	private String password;
}

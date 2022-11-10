package com.dacg.api.pokedex.config;

public class Constants {

	// Spring Security

    public static final String LOGIN_URL = "/usuario";
    public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
    public static final String TOKEN_BEARER_PREFIX = "Bearer ";

    // JWT

    public static final String ISSUER_INFO = "https://localhost";
    public static final String SUPER_SECRET_KEY = "llaveSecreta1234";
    public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 dias
}

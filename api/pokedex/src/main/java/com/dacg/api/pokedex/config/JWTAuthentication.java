package com.dacg.api.pokedex.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.dacg.api.pokedex.modelo.UserModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import static com.dacg.api.pokedex.config.Constants.*;

public class JWTAuthentication extends UsernamePasswordAuthenticationFilter {

	   private AuthenticationManager authenticationManager;

	    public JWTAuthentication(AuthenticationManager authenticationManager) {
	        this.authenticationManager = authenticationManager;
	    }

	    @Override
	    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
	            throws AuthenticationException {
	        try {
	        	UserModel credentials = new ObjectMapper().readValue(request.getInputStream(), UserModel.class);

	            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
	                    credentials.getUsername(), credentials.getPassword(), new ArrayList<>()));
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	    }

	    @Override
	    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
	                                            Authentication auth) throws IOException, ServletException {

	        String token = Jwts.builder().setIssuedAt(new Date()).setIssuer(ISSUER_INFO)
	                .setSubject(((org.springframework.security.core.userdetails.User)auth.getPrincipal()).getUsername())
	                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
	                .signWith(SignatureAlgorithm.HS512, SUPER_SECRET_KEY).compact();
	        response.addHeader(HEADER_AUTHORIZACION_KEY, TOKEN_BEARER_PREFIX + token);
	    }
}

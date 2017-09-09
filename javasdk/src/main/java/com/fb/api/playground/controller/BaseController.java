package com.fb.api.playground.controller;

import org.springframework.stereotype.Controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Controller
public class BaseController {

	public String getToken(String email, Long id){
		String token = Jwts.builder().setSubject(email).setId(id+"").signWith(SignatureAlgorithm.HS512, "fb-api-playground").compact();
		return token;
	};
	
	public String getIdFromToken(String token){
		String userId = null;
		if(token != null) {
			Jws<Claims> jws = Jwts.parser().setSigningKey("fb-api-playground").parseClaimsJws(token);
			userId = jws.getBody().getId();
		}
		return userId;
	}
}

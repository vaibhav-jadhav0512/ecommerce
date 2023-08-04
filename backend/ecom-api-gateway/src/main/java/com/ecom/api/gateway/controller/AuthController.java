package com.ecom.api.gateway.controller;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.api.gateway.model.AuthResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@GetMapping("/login")
	public ResponseEntity<AuthResponse>login(@AuthenticationPrincipal OidcUser user,Model model,@RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client){
		AuthResponse response = AuthResponse.builder().userId(user.getEmail())
				.accessToken(client.getAccessToken().getTokenValue())
				.refreshToken(client.getRefreshToken().getTokenValue())
				.expiresAt(client.getAccessToken().getExpiresAt().getEpochSecond())
				.authorityList(
						user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.build();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}

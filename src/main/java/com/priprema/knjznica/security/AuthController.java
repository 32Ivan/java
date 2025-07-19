package com.priprema.knjznica.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return authService.createUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        return authService.login(authRequest);
    }

    @PostMapping("/access-token")
    public ResponseEntity<?> getAccessToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.getAccessToken(refreshTokenRequest.getRefreshToken());
    }
}

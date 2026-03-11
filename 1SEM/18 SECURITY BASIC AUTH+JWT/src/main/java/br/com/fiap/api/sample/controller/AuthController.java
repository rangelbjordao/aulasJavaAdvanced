package br.com.fiap.api.sample.controller;

import br.com.fiap.api.sample.JwtUtil;
import br.com.fiap.api.sample.dto.RegisterDTO;
import br.com.fiap.api.sample.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final UsuarioService usuarioService;

    public AuthController(AuthenticationManager authManager, JwtUtil jwtUtil, UsuarioService usuarioService) {
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest body) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(body.username, body.password)
        );
        String token = jwtUtil.generateToken(auth.getName());
        return ResponseEntity.ok(new TokenResponse(token, "Bearer"));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO registerDTO) {
        if (usuarioService.loadUserByUsername(registerDTO.email) != null)
    }

    public record LoginRequest(String username, String password) { }
    public record TokenResponse(String accessToken, String tokenType) { }
}
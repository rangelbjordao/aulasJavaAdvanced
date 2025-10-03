package br.com.fiap.api.sample;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authManager, JwtUtil jwtUtil) {
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest body) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(body.username, body.password)
        );
        String token = jwtUtil.generateToken(auth.getName());
        return ResponseEntity.ok(new TokenResponse(token, "Bearer"));
    }

    public record LoginRequest(String username, String password) { }
    public record TokenResponse(String accessToken, String tokenType) { }
}
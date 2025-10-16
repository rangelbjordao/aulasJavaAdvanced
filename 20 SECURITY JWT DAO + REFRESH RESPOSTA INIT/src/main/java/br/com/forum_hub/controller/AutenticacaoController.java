package br.com.forum_hub.controller;

import br.com.forum_hub.domain.autenticacao.DadosLogin;
import br.com.forum_hub.domain.autenticacao.TokenService;
import br.com.forum_hub.domain.usuario.Usuario;
import br.com.forum_hub.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutenticacaoController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UsuarioRepository usuarioRepository;

    public AutenticacaoController(AuthenticationManager authenticationManager, TokenService tokenService, UsuarioRepository usuarioRepository) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<String> efetuarLogin(@Valid @RequestBody DadosLogin dados){
        var autenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.password());
        var authentication = authenticationManager.authenticate(autenticationToken);

        String tokenAcesso = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(tokenAcesso);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO registerDTO) {
        if (usuarioRepository.findByEmailIgnoreCase(registerDTO.email).isPresent()){
            return ResponseEntity.badRequest().build();
        }
        String senhaCriptografada = new BCryptPasswordEncoder().encode(registerDTO.password);
        saveUsuario(registerDTO.email, senhaCriptografada);
        return ResponseEntity.ok().build();
    }

    public Usuario saveUsuario(String email, String senhaCriptografada) {
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setSenha(senhaCriptografada);
        return usuarioRepository.save(usuario);
    }

    public record RegisterDTO(String email, String password) {}

}

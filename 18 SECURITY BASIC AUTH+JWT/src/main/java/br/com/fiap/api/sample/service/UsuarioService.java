package br.com.fiap.api.sample.service;

import br.com.fiap.api.sample.domain.Usuario;
import br.com.fiap.api.sample.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByEmailIgnoreCase(username)
                .orElseThrow(() -> new UsernameNotFoundException("O usuario nao foi encontrado"));
    }

    public void saveUsuario(String email, String senhaCriptogragada) {
        Usuario usuario = new Usuario;
    }
}

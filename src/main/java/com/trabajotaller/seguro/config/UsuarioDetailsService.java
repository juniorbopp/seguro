
package com.trabajotaller.seguro.config;

import com.trabajotaller.seguro.entidad.Usuario;
import com.trabajotaller.seguro.repositorios.usuarioRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    private final usuarioRepo usuarioRepository;

    public UsuarioDetailsService(usuarioRepo usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String correo)
            throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByCorreo(correo)
            .orElseThrow(() ->
                new UsernameNotFoundException("Usuario no encontrado")
            );

        return org.springframework.security.core.userdetails.User
            .withUsername(usuario.getCorreo())
            .password(usuario.getContrasena())
            .authorities("ROLE_" + usuario.getRol())
            .disabled(!usuario.isEstado())
            .build();
    }
}
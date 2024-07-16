package com.alura.ForoHub.infra.security;

import com.alura.ForoHub.domain.usuario.UsuarioRepository;
import com.alura.ForoHub.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuariosRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        if (!requestURI.equals("/login")) {
            //Se obtiene el token del header
            var authHeader = request.getHeader("Authorization");
            if (authHeader == "" || authHeader == null) {
                throw new RuntimeException("Token inválido");
            }
            var token = authHeader.replace("Bearer ", "");
            var username = tokenService.getSubject(token);
            if (username != null) {
                var usuario = usuariosRepository.findByUser(username);
                //Forzamos inicio de sesion
                var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }
}
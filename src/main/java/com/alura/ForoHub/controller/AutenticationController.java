package com.alura.ForoHub.controller;

import com.alura.ForoHub.domain.usuario.DatosValidarUsuario;
import com.alura.ForoHub.domain.usuario.Usuario;
import com.alura.ForoHub.infra.security.DatosJWTToken;
import com.alura.ForoHub.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody DatosValidarUsuario datosValidarUsuario) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosValidarUsuario.user(), datosValidarUsuario.pass());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTToken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTToken) );
    }

}
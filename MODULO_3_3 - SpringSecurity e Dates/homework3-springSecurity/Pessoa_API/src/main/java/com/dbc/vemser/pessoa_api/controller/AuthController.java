package com.dbc.vemser.pessoa_api.controller;

import com.dbc.vemser.pessoa_api.dto.LoginDTO;
import com.dbc.vemser.pessoa_api.dto.LoginDTOComToken;
import com.dbc.vemser.pessoa_api.entity.Roles;
import com.dbc.vemser.pessoa_api.entity.UsuarioEntity;
import com.dbc.vemser.pessoa_api.exceptions.RegraDeNegocioException;
import com.dbc.vemser.pessoa_api.security.TokenService;
import com.dbc.vemser.pessoa_api.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.mail.search.SearchTerm;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {

    private final UsuarioService usuarioService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping
    public String auth(@RequestBody @Valid LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getLogin(),
                        loginDTO.getSenha()
                );

        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        String token = tokenService.getToken(authenticate);
        return token;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<LoginDTOComToken> cadastro(@RequestBody @Valid LoginDTO loginDTO, @RequestParam List<Roles> roles) throws RegraDeNegocioException {
        usuarioService.cadastro(loginDTO, roles);
        String token = auth(loginDTO);
        LoginDTOComToken loginDTOComToken = new LoginDTOComToken();
        loginDTOComToken.setLogin(loginDTO.getLogin());
        loginDTOComToken.setToken(token);
        return ResponseEntity.ok(loginDTOComToken);
    }
}

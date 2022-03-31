package com.dbc.vemser.pessoa_api.service;

import com.dbc.vemser.pessoa_api.dto.LoginDTO;
import com.dbc.vemser.pessoa_api.entity.UsuarioEntity;
import com.dbc.vemser.pessoa_api.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final ObjectMapper objectMapper;

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha){
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public LoginDTO cadastro(LoginDTO loginDTO) {
        UsuarioEntity novoUsuario = objectMapper.convertValue(loginDTO, UsuarioEntity.class);
        novoUsuario.setSenha(new BCryptPasswordEncoder().encode(loginDTO.getSenha()));
        usuarioRepository.save(novoUsuario);
        return loginDTO;
    }
}

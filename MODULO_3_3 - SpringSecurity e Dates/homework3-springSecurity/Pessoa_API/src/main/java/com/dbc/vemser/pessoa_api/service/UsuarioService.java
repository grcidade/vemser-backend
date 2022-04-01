package com.dbc.vemser.pessoa_api.service;

import com.dbc.vemser.pessoa_api.dto.LoginDTO;
import com.dbc.vemser.pessoa_api.entity.GrupoEntity;
import com.dbc.vemser.pessoa_api.entity.Roles;
import com.dbc.vemser.pessoa_api.entity.UsuarioEntity;
import com.dbc.vemser.pessoa_api.exceptions.RegraDeNegocioException;
import com.dbc.vemser.pessoa_api.repository.GroupRepository;
import com.dbc.vemser.pessoa_api.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final ObjectMapper objectMapper;
    private final GroupService groupService;

    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public void cadastro(LoginDTO loginDTO, List<Roles> rolesList) throws RegraDeNegocioException {

        UsuarioEntity novoUsuario = objectMapper.convertValue(loginDTO, UsuarioEntity.class);

        Set<GrupoEntity> grupoRoles = new HashSet<>();

        for(Roles roles : rolesList){
            GrupoEntity grupoEntity = groupService.getById(roles.getRole());
            grupoRoles.add(grupoEntity);
        }

        novoUsuario.setGrupos(grupoRoles);
        novoUsuario.setSenha(new BCryptPasswordEncoder().encode(loginDTO.getSenha()));
        usuarioRepository.save(novoUsuario);
    }
}

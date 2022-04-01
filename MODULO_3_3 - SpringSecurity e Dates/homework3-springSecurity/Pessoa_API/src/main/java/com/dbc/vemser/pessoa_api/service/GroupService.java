package com.dbc.vemser.pessoa_api.service;

import com.dbc.vemser.pessoa_api.entity.GrupoEntity;
import com.dbc.vemser.pessoa_api.exceptions.RegraDeNegocioException;
import com.dbc.vemser.pessoa_api.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    public GrupoEntity getById(Integer id) throws RegraDeNegocioException {
        return groupRepository.findById(id).orElseThrow(() -> new RegraDeNegocioException("Grupo não encontrado"));
    }
}

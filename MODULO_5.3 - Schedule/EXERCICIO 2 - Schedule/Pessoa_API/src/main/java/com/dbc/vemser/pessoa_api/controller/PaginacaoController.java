package com.dbc.vemser.pessoa_api.controller;

import com.dbc.vemser.pessoa_api.entity.ContatoEntity;
import com.dbc.vemser.pessoa_api.entity.EnderecoEntity;
import com.dbc.vemser.pessoa_api.repository.ContatoRepository;
import com.dbc.vemser.pessoa_api.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paginacao")
@Validated
@RequiredArgsConstructor
public class PaginacaoController {

    private final ContatoRepository contatoRepository;
    private final EnderecoRepository enderecoRepository;

    @GetMapping
    public Page<ContatoEntity> listarContatosPorDescricao(Integer paginaSolicitada, Integer tamanhoPagina){
        Pageable pageable = PageRequest.of(paginaSolicitada, tamanhoPagina, Sort.by("descricao"));
        return contatoRepository.findAll(pageable);
    }

    @GetMapping("/enderecosOrdemCep")
    public Page<EnderecoEntity> listarEnderecosPorCep(Integer paginaSolicitada, Integer tamanhoPagina){
        Pageable pageable = PageRequest.of(paginaSolicitada, tamanhoPagina, Sort.by("cep"));
        return enderecoRepository.findAll(pageable);
    }

}

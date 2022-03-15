package com.dbc.vemser.homework4_DTOs.service;

import com.dbc.vemser.homework4_DTOs.dto.PessoaCreateDTO;
import com.dbc.vemser.homework4_DTOs.dto.PessoaDTO;
import com.dbc.vemser.homework4_DTOs.entity.Pessoa;
import com.dbc.vemser.homework4_DTOs.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ObjectMapper objectMapper;

    public PessoaDTO create(PessoaCreateDTO pessoaCreate) throws Exception {
        log.info("Chamou criar pessoa");
        Pessoa pessoa = objectMapper.convertValue(pessoaCreate, Pessoa.class);
        return objectMapper.convertValue(pessoaRepository.create(pessoa), PessoaDTO.class);
    }

    public List<PessoaDTO> list(){
        log.info("Chamou listar pessoa");
        return pessoaRepository.list().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws Exception {
        log.info("Chamou atualizar pessoa");
        Pessoa pessoa = objectMapper.convertValue(pessoaAtualizar, Pessoa.class);
        return objectMapper.convertValue(pessoaRepository.update(id, pessoa), PessoaDTO.class);
    }

    public void delete(Integer id) throws Exception {
        log.info("Chamou deletar pessoa");
        pessoaRepository.delete(id);
    }

    public List<PessoaDTO> listByName(String nome) {
        log.info("Chamou listar pessoa por nome");
        return pessoaRepository.listByName(nome).stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }
}

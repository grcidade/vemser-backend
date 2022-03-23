package com.dbc.vemser.pessoa_api.service;


import com.dbc.vemser.pessoa_api.dto.ContatoCreateDTO;
import com.dbc.vemser.pessoa_api.dto.ContatoDTO;
import com.dbc.vemser.pessoa_api.entity.ContatoEntity;
import com.dbc.vemser.pessoa_api.entity.PessoaEntity;
import com.dbc.vemser.pessoa_api.exceptions.RegraDeNegocioException;
import com.dbc.vemser.pessoa_api.repository.ContatoRepository;
import com.dbc.vemser.pessoa_api.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log
@Service
@RequiredArgsConstructor
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;
    private final PessoaService pessoaService;

    // TODO: 23/03/2022 Tirar pessoa repository e trocar tudo para pessoa service

    public List<ContatoDTO> listarContatos(){
        log.info("Chamou listar contatos");
        return contatoRepository.findAll().stream()
                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public void deletarContatos(Integer id) throws Exception {
        log.info("Chamou deletar contatos");
        contatoRepository.deleteById(id);
    }

    public ContatoDTO criarContato(ContatoCreateDTO contatoCriado) throws RegraDeNegocioException {
        pessoaRepository.findAll().stream()
                        .filter(pessoaEntity -> pessoaEntity.getIdPessoa().equals(contatoCriado.getIdPessoa()))
                                .findFirst().orElseThrow(()-> new RegraDeNegocioException("Pessoa não encontrada"));
        log.info("Chamou criar contatoEntity");
        ContatoEntity contatoEntity = objectMapper.convertValue(contatoCriado, ContatoEntity.class);
        PessoaEntity pessoaEntity = pessoaService.findById(contatoCriado.getIdPessoa());
        contatoEntity.setPessoaEntity(pessoaEntity);
        contatoEntity.setIdPessoa(contatoCriado.getIdPessoa());
        return objectMapper.convertValue(contatoRepository.save(contatoEntity), ContatoDTO.class);
    }

    public List<ContatoDTO> findContatoByIdPessoa(Integer id) throws RegraDeNegocioException {
        log.info("Chamou achar contato por ID PESSOA");
        return contatoRepository.findAll().stream()
                .filter(contatoEntity -> contatoEntity.getIdPessoa().equals(id))
                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public ContatoDTO atualizarContato(Integer id, ContatoCreateDTO novoContato) throws Exception {
        pessoaRepository.findById(novoContato.getIdPessoa()).orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
        log.info("Chamou atualizar contatoEntity");

        ContatoEntity contatoBuscado = contatoRepository.findById(id).orElseThrow(()-> new RegraDeNegocioException("Contato não encontrado"));

        contatoBuscado.setTipoContato(novoContato.getTipoContato());
        contatoBuscado.setDescricao(novoContato.getDescricao());
        contatoBuscado.setNumero(novoContato.getNumero());
        contatoBuscado.setIdPessoa(novoContato.getIdPessoa());

        return objectMapper.convertValue(contatoRepository.save(contatoBuscado), ContatoDTO.class);
    }

    public ContatoDTO findById(Integer id) throws Exception {
        log.info("Chamou achar contato por ID CONTATO");
        return objectMapper.convertValue(contatoRepository.findById(id), ContatoDTO.class);
    }

}

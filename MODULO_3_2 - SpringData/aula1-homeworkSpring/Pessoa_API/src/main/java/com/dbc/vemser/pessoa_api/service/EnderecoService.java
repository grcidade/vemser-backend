package com.dbc.vemser.pessoa_api.service;

import com.dbc.vemser.pessoa_api.dto.EnderecoCreateDTO;
import com.dbc.vemser.pessoa_api.dto.EnderecoDTO;
import com.dbc.vemser.pessoa_api.dto.PessoaDTO;
import com.dbc.vemser.pessoa_api.entity.EnderecoEntity;
import com.dbc.vemser.pessoa_api.exceptions.RegraDeNegocioException;
import com.dbc.vemser.pessoa_api.repository.EnderecoRepository;
import com.dbc.vemser.pessoa_api.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;

    public EnderecoDTO criarEndereco(EnderecoCreateDTO enderecoCriar) throws Exception {
        log.info("Chamou criar endereço");
        EnderecoEntity enderecoCriado = objectMapper.convertValue(enderecoCriar, EnderecoEntity.class);
        return objectMapper.convertValue(enderecoRepository.save(enderecoCriado), EnderecoDTO.class);
    }

    public void deletarEndereco(Integer id) throws Exception {
        log.info("Chamou deletar endereço");
        enderecoRepository.deleteById(id);
    }

    public EnderecoDTO editarEndereco(Integer id, EnderecoCreateDTO novoEndereco) throws Exception {
        log.info("Chamou editar endereço");
        EnderecoEntity enderecoBuscado = enderecoRepository.findById(id).orElseThrow(()-> new RegraDeNegocioException("Endereço não encontrado"));
        enderecoBuscado.setCep(novoEndereco.getCep());
        enderecoBuscado.setCidade(novoEndereco.getCidade());
        enderecoBuscado.setNumero(novoEndereco.getNumero());
        enderecoBuscado.setPais(novoEndereco.getPais());
        enderecoBuscado.setTipo(novoEndereco.getTipo());
        enderecoBuscado.setLogradouro(novoEndereco.getLogradouro());
        enderecoBuscado.setEstado(novoEndereco.getEstado());
        enderecoBuscado.setComplemento(novoEndereco.getComplemento());

        return objectMapper.convertValue(enderecoRepository.save(enderecoBuscado), EnderecoDTO.class);
    }

    public EnderecoDTO getByIdEndereco(Integer id) throws Exception {
        log.info("Chamou achar endereço por ID");
        return objectMapper.convertValue(enderecoRepository.findById(id).orElseThrow(()-> new RegraDeNegocioException("Endereço não encontrado")), EnderecoDTO.class);
    }

    public List<EnderecoDTO> listarEnderecos(){
        log.info("Chamou listar endereços");
        return enderecoRepository.findAll().stream()
                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

}

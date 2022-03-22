package com.dbc.vemser.pessoa_api.service;

import com.dbc.vemser.pessoa_api.dto.PessoaCreateDTO;
import com.dbc.vemser.pessoa_api.dto.PessoaDTO;
import com.dbc.vemser.pessoa_api.entity.PessoaEntity;
import com.dbc.vemser.pessoa_api.exceptions.RegraDeNegocioException;
import com.dbc.vemser.pessoa_api.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log
@RequiredArgsConstructor
public class PessoaService {


    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;

    public PessoaDTO create(PessoaCreateDTO pessoaCreate) throws Exception {
        log.info("Chamou criar pessoaEntity");
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoaCreate, PessoaEntity.class);
        PessoaEntity pessoaEntityCriada = pessoaRepository.save(pessoaEntity);
        return objectMapper.convertValue(pessoaEntityCriada, PessoaDTO.class);
//        emailService.sendSimpleMessage(pessoaEntityCriada);
//        emailService.sendWithAttachment(pessoaEntityCriada);
//        emailService.sendEmail(pessoaDTO, "create");
    }

    public List<PessoaDTO> list(){
        log.info("Chamou listar pessoa");
        return pessoaRepository.findAll().stream().map(pessoaEntity -> objectMapper.convertValue(pessoaEntity, PessoaDTO.class)).collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws Exception {
        log.info("Chamou atualizar pessoaEntity");

        PessoaEntity pessoaParaAtualizar = pessoaRepository.findById(id).orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));

        pessoaParaAtualizar.setNome(pessoaAtualizar.getNome());
        pessoaParaAtualizar.setCpf(pessoaAtualizar.getCpf());
        pessoaParaAtualizar.setDataNascimento(pessoaAtualizar.getDataNascimento());
        pessoaParaAtualizar.setEmail(pessoaAtualizar.getEmail());

        PessoaEntity pessoaAtualizada = pessoaRepository.save(pessoaParaAtualizar);

        return objectMapper.convertValue(pessoaAtualizada, PessoaDTO.class);
    }

    public void delete(Integer id) throws Exception {
        log.info("Chamou deletar pessoa");
//        emailService.sendEmail(pessoaDTOparaMandarEmail, "delete");
        pessoaRepository.deleteById(id);
    }

}

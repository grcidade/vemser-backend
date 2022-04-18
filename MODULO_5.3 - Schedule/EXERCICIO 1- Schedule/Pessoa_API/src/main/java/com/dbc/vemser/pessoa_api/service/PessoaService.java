package com.dbc.vemser.pessoa_api.service;

import com.dbc.vemser.pessoa_api.dto.*;
import com.dbc.vemser.pessoa_api.entity.PessoaEntity;
import com.dbc.vemser.pessoa_api.exceptions.RegraDeNegocioException;
import com.dbc.vemser.pessoa_api.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PessoaService {


    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;

    @Scheduled(cron = "0 0 8,20 * * *")
    public void sendEmailIfHasNoAddress(){
        List<PessoaEntity> pessoasSemEndereco = pessoaRepository.getPessoasSemEndereco();
        List<PessoaDTO> pessosasDTOSemEndereco = pessoasSemEndereco.stream().map(pessoaEntity -> objectMapper.convertValue(pessoaEntity, PessoaDTO.class)).toList();
        for(PessoaDTO pessoaSemEndereco : pessosasDTOSemEndereco){
            emailService.sendSimpleMessage(pessoaSemEndereco);
        }
    }

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

    public List<PessoaDTOComContatos> listarPessoasComContatos(Integer idPessoa) throws Exception {
        List<PessoaDTOComContatos> listPessoasDTOComContatos = new ArrayList<>();
        if (idPessoa == null) {
            listPessoasDTOComContatos.addAll(pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        PessoaDTOComContatos pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTOComContatos.class);
                        pessoaDTO.setContatos(pessoa.getContatos().stream()
                                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                                .collect(Collectors.toList())
                        );
                        return pessoaDTO;
                    }).toList()
            );
        } else {
            PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa)
                    .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
            PessoaDTOComContatos pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTOComContatos.class);
            pessoaDTO.setContatos(pessoaEntity.getContatos().stream()
                    .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                    .collect(Collectors.toList())
            );
            listPessoasDTOComContatos.add(pessoaDTO);
        }
        return listPessoasDTOComContatos;
    }

    public List<PessoaDTOComEnderecos> listarPessoasComEnderecos(Integer idPessoa) throws Exception {
        List<PessoaDTOComEnderecos> listPessoasDTOComEnderecos = new ArrayList<>();
        if (idPessoa == null) {
            listPessoasDTOComEnderecos.addAll(pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        PessoaDTOComEnderecos pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTOComEnderecos.class);
                        pessoaDTO.setEnderecos(pessoa.getEnderecos().stream()
                                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                                .collect(Collectors.toList())
                        );
                        return pessoaDTO;
                    }).toList()
            );
        } else {
            PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa)
                    .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
            PessoaDTOComEnderecos pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTOComEnderecos.class);
            pessoaDTO.setEnderecos(pessoaEntity.getEnderecos().stream()
                    .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                    .collect(Collectors.toList())
            );
            listPessoasDTOComEnderecos.add(pessoaDTO);
        }
        return listPessoasDTOComEnderecos;
    }

    public PessoaEntity findById(Integer idPessoa) throws RegraDeNegocioException {
        return pessoaRepository.findById(idPessoa).orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
    }

    public List<PessoaDTOComContatosEEnderecos> getPessoaCompleta() throws Exception {
        return new ArrayList<>(pessoaRepository.findAll().stream().map(this::retornarTodosDadosDaPessoa).toList());
    }

    private PessoaDTOComContatosEEnderecos retornarTodosDadosDaPessoa(PessoaEntity pessoaEntity) {
        PessoaDTOComContatosEEnderecos pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTOComContatosEEnderecos.class);
        pessoaDTO.setContatos(pessoaEntity.getContatos().stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList())
        );
        pessoaDTO.setEnderecos(pessoaEntity.getEnderecos().stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList())
        );
        return pessoaDTO;
    }

}

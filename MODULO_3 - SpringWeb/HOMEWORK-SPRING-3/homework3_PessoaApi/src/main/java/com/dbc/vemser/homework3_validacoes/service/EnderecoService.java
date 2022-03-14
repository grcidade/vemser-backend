package com.dbc.vemser.homework3_validacoes.service;

import com.dbc.vemser.homework3_validacoes.entity.Endereco;
import com.dbc.vemser.homework3_validacoes.exceptions.RegraDeNegocioException;
import com.dbc.vemser.homework3_validacoes.repository.EnderecoRepository;
import com.dbc.vemser.homework3_validacoes.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    public Endereco criarEndereco(Integer id, Endereco endereco) throws Exception {
        return enderecoRepository.create(endereco, id);
    }

    public void deletarEndereco(Integer id) throws Exception {
        enderecoRepository.delete(id);
    }

    public Endereco getByIdEndereco(Integer id) throws Exception {
        return enderecoRepository.getByIdEndereco(id);
    }

    public List<Endereco> getByIdPessoa(Integer id) throws Exception {
        return enderecoRepository.getByIdPessoa(id);
    }

    public List<Endereco> listarEnderecos(){
        return enderecoRepository.list();    }

    public Endereco editarEndereco(Integer id, Endereco novoEndereco) throws Exception {
        if(pessoaRepository.getById(novoEndereco.getIdPessoa()) == null){
            throw new RegraDeNegocioException("Pessoa não encontrada!");
        }
        return enderecoRepository.update(novoEndereco, id);
    }

}

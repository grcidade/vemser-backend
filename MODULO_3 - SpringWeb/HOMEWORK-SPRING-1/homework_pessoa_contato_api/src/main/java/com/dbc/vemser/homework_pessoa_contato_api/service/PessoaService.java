package com.dbc.vemser.homework_pessoa_contato_api.service;

import com.dbc.vemser.homework_pessoa_contato_api.entity.Pessoa;
import com.dbc.vemser.homework_pessoa_contato_api.repository.PessoaRepository;

import java.util.List;

public class PessoaService {

    private final PessoaRepository pessoaRepository = new PessoaRepository();

    public Pessoa create(Pessoa pessoa){
        return pessoaRepository.create(pessoa);
    }

    public List<Pessoa> list(){
        return pessoaRepository.list();
    }

    public Pessoa update(Integer id,
                         Pessoa pessoaAtualizar) throws Exception {
        return pessoaRepository.update(id, pessoaAtualizar);
    }

    public void delete(Integer id) throws Exception {
        pessoaRepository.delete(id);
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.listByName(nome);
    }
}

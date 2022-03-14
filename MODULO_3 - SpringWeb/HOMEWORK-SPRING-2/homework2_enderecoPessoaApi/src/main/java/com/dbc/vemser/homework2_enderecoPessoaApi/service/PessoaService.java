package com.dbc.vemser.homework2_enderecoPessoaApi.service;

import com.dbc.vemser.homework2_enderecoPessoaApi.repository.PessoaRepository;
import com.dbc.vemser.homework2_enderecoPessoaApi.entity.Pessoa;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa create(Pessoa pessoa){
        try{
            if(StringUtils.isBlank(pessoa.getNome())){
                throw new Exception("Nome não pode estar em branco");
            }

            if(ObjectUtils.isEmpty(pessoa.getDataNascimento())){
                throw new Exception("Insira uma data de nascimento!");
            }

            if(StringUtils.isBlank(pessoa.getCpf()) || StringUtils.length(pessoa.getCpf()) != 11){
                throw new Exception("CPF precisa ter 11 digitos");
            }

            return pessoaRepository.create(pessoa);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Pessoa> list(){
        return pessoaRepository.list();
    }

    public Pessoa update(Integer id, Pessoa pessoaAtualizar) throws Exception {
        return pessoaRepository.update(id, pessoaAtualizar);
    }

    public void delete(Integer id) throws Exception {
        pessoaRepository.delete(id);
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.listByName(nome);
    }
}

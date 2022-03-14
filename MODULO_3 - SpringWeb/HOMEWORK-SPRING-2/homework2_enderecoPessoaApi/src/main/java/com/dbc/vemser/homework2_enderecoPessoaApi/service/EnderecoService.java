package com.dbc.vemser.homework2_enderecoPessoaApi.service;

import com.dbc.vemser.homework2_enderecoPessoaApi.entity.Endereco;
import com.dbc.vemser.homework2_enderecoPessoaApi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    public Endereco criarEndereco(Integer id, Endereco endereco){
            return enderecoRepository.create(endereco, id);
    }

    public void deletarEndereco(Integer id){
        try{
            enderecoRepository.delete(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Endereco getByIdEndereco(Integer id) throws Exception {
        return enderecoRepository.getByIdEndereço(id);
    }

    public List<Endereco> getByIdPessoa(Integer id) throws Exception {
        return enderecoRepository.getByIdPessoa(id);
    }

    public List<Endereco> listarEnderecos(){
        return enderecoRepository.list();
    }

    public Endereco editarEndereco(Integer id, Endereco novoEndereco) throws Exception {
        return enderecoRepository.update(novoEndereco, id);
    }

}

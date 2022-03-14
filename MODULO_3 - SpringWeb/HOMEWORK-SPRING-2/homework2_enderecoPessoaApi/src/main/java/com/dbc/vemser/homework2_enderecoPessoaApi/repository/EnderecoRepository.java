package com.dbc.vemser.homework2_enderecoPessoaApi.repository;

import com.dbc.vemser.homework2_enderecoPessoaApi.entity.Endereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {

    List<Endereco> enderecoList = new ArrayList<>();
    AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository(){
        enderecoList.add(new Endereco(COUNTER.incrementAndGet(), 1, "Rua Amapa", "24", "Vila Cachoeirinha", "Cachoeirinha", "RS"));
        enderecoList.add(new Endereco(COUNTER.incrementAndGet(), 2, "Rua Santos", "1", "Anair", "Cachoeirinha", "RS"));
        enderecoList.add(new Endereco(COUNTER.incrementAndGet(), 3, "Rua Criciuma", "125", "Morada do Bosque", "Cachoeirinha", "RS"));
        enderecoList.add(new Endereco(COUNTER.incrementAndGet(), 1, "Rua Tapajos", "78", "Vila Famatia", "Cachoeirinha", "RS"));
        enderecoList.add(new Endereco(COUNTER.incrementAndGet(), 2, "Rua Dinamarca", "3", "Vila Cachoeirinha", "Cachoeirinha", "RS"));
    }

    public Endereco create(Endereco endereco, Integer id){
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        endereco.setIdPessoa(id);
        enderecoList.add(endereco);
        return endereco;
    }

    public void delete(Integer id) throws Exception {
        Endereco enderecoRecuperado = enderecoList.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(Exception::new);
        enderecoList.remove(enderecoRecuperado);
    }

    public List<Endereco> list(){
        return enderecoList;
    }

    public Endereco getByIdEndereço(Integer id) throws Exception {
        return enderecoList.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(Exception::new);
    }

    public List<Endereco> getByIdPessoa(Integer id) throws Exception {
        return enderecoList.stream()
                .filter(endereco -> endereco.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }

    public Endereco update(Endereco novoEndereco, Integer id) throws Exception {
        Endereco enderecoRecuperado = enderecoList.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(Exception::new);
        enderecoRecuperado.setIdPessoa(novoEndereco.getIdPessoa());
        enderecoRecuperado.setNumero(novoEndereco.getNumero());
        enderecoRecuperado.setBairro(novoEndereco.getBairro());
        enderecoRecuperado.setCidade(novoEndereco.getCidade());
        enderecoRecuperado.setLogradouro(novoEndereco.getLogradouro());
        enderecoRecuperado.setEstado(novoEndereco.getEstado());
        return enderecoRecuperado;
    }

}

package com.dbc.vemser.homework3_validacoes.service;

import com.dbc.vemser.homework3_validacoes.entity.Contato;
import com.dbc.vemser.homework3_validacoes.exceptions.RegraDeNegocioException;
import com.dbc.vemser.homework3_validacoes.repository.ContatoRepository;
import com.dbc.vemser.homework3_validacoes.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Contato> listarContatos(){
        return contatoRepository.list();
    }

    public void deletarContatos(Integer id) throws Exception {
        contatoRepository.delete(id);
    }

    public Contato criarContato(Contato contato) throws RegraDeNegocioException {
        if(pessoaRepository.getById(contato.getIdPessoa()) == null){
            throw new RegraDeNegocioException("Pessoa não encontrada!");
        }
        return contatoRepository.create(contato);
    }

    public List<Contato> findContatoByIdPessoa(Integer id){
        return contatoRepository.findContatoByIdPessoa(id);
    }

    public Contato atualizarContato(Integer id, Contato novoContato) throws Exception {
        if(pessoaRepository.getById(novoContato.getIdPessoa()) == null){
            throw new RegraDeNegocioException("Pessoa não encontrada!");
        }
        return contatoRepository.update(id, novoContato);
    }

    public Contato findById(Integer id) throws Exception {
        return contatoRepository.findContatoById(id);
    }

}

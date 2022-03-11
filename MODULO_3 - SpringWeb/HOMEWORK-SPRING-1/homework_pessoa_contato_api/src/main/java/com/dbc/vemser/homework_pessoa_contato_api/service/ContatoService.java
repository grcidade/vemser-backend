package com.dbc.vemser.homework_pessoa_contato_api.service;

import com.dbc.vemser.homework_pessoa_contato_api.entity.Contato;
import com.dbc.vemser.homework_pessoa_contato_api.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public List<Contato> listarContatos(){
        return contatoRepository.list();
    }

    public void deletarContatos(Integer id){
        try{
            contatoRepository.delete(id);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Contato criarContato(Contato contato){
        return contatoRepository.create(contato);
    }

    public List<Contato> findContatoByIdPessoa(Integer id){
        return contatoRepository.findContatoByIdPessoa(id);
    }

    public Contato atualizarContato(Integer id, Contato novoContato) throws Exception {
        return contatoRepository.update(id, novoContato);
    }

    public Contato findById(Integer id) throws Exception {
        return contatoRepository.findContatoById(id);
    }

}

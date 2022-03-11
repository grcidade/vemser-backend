package com.dbc.vemser.homework_pessoa_contato_api.controller;

import com.dbc.vemser.homework_pessoa_contato_api.entity.Contato;
import com.dbc.vemser.homework_pessoa_contato_api.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public List<Contato> list(){
        return contatoService.listarContatos();
    }

    @GetMapping("/{idContato}")
    public Contato findById(@PathVariable("idContato") Integer id) throws Exception {
        return contatoService.findById(id);
    }

    @GetMapping("/byIdPessoa/{idPessoa}")
    public List<Contato> findByIdPessoa(@PathVariable("idPessoa") Integer id) {
        return contatoService.findContatoByIdPessoa(id);
    }

    @PostMapping
    public Contato create(@RequestBody Contato contato){
        return contatoService.criarContato(contato);
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer id){
        contatoService.deletarContatos(id);
    }

    @PutMapping("/{idContato}")
    public Contato update(@PathVariable("idContato") Integer id,
                          @RequestBody Contato contatoAtualizar) throws Exception {
        return contatoService.atualizarContato(id, contatoAtualizar);
    }
}

package com.dbc.vemser.homework3_validacoes.controller;

import com.dbc.vemser.homework3_validacoes.entity.Contato;
import com.dbc.vemser.homework3_validacoes.exceptions.RegraDeNegocioException;
import com.dbc.vemser.homework3_validacoes.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato")
@Validated
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public ResponseEntity<List<Contato>> list(){
        return new ResponseEntity<>(contatoService.listarContatos(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{idContato}")
    public ResponseEntity<Contato> findById(@PathVariable("idContato") Integer id) throws Exception {
        return new ResponseEntity<>(contatoService.findById(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/byIdPessoa/{idPessoa}")
    public ResponseEntity<List<Contato>> findByIdPessoa(@PathVariable("idPessoa") Integer id) {
        return new ResponseEntity<>(contatoService.findContatoByIdPessoa(id), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<Contato> create(@Valid @RequestBody Contato contato) throws RegraDeNegocioException {
        return new ResponseEntity<>(contatoService.criarContato(contato), HttpStatus.CREATED);
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.deletarContatos(id);
    }

    @PutMapping("/{idContato}")
    public ResponseEntity<Contato> update(@PathVariable("idContato") Integer id,
                          @Valid @RequestBody Contato contatoAtualizar) throws Exception {
        return new ResponseEntity<>(contatoService.atualizarContato(id, contatoAtualizar), HttpStatus.ACCEPTED);
    }
}

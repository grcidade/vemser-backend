package com.dbc.vemser.homework3_validacoes.controller;

import com.dbc.vemser.homework3_validacoes.entity.Pessoa;
import com.dbc.vemser.homework3_validacoes.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
@Validated
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/hello") // localhost:8080/pessoa/hello
    public String hello() {
        return "Hello world!";
    }

    @PostMapping // localhost:8080/pessoa
    public ResponseEntity<Pessoa> create(@Valid @RequestBody Pessoa pessoa) {
        return new ResponseEntity<>(pessoa, HttpStatus.CREATED);
    }

    @GetMapping // localhost:8080/pessoa
    public ResponseEntity<List<Pessoa>> list() {
        return new ResponseEntity<>(pessoaService.list(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/byname") // localhost:8080/pessoa/byname?nome=Rafa
    public ResponseEntity<List<Pessoa>> listByName(@RequestParam("nome") String nome) {
        return new ResponseEntity<>(pessoaService.listByName(nome), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public ResponseEntity<Pessoa> update(@PathVariable("idPessoa") Integer id,
                         @Valid @RequestBody Pessoa pessoaAtualizar) throws Exception {
        return new ResponseEntity<>(pessoaService.update(id, pessoaAtualizar), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }
}

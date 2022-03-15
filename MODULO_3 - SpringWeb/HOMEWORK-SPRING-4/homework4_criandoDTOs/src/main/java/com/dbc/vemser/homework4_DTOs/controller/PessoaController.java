package com.dbc.vemser.homework4_DTOs.controller;

import com.dbc.vemser.homework4_DTOs.dto.PessoaCreateDTO;
import com.dbc.vemser.homework4_DTOs.dto.PessoaDTO;
import com.dbc.vemser.homework4_DTOs.service.PessoaService;
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
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) throws Exception {
        return new ResponseEntity<>(pessoaService.create(pessoa), HttpStatus.CREATED);
    }

    @GetMapping // localhost:8080/pessoa
    public ResponseEntity<List<PessoaDTO>> list() {
        return new ResponseEntity<>(pessoaService.list(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/byname") // localhost:8080/pessoa/byname?nome=Rafa
    public ResponseEntity<List<PessoaDTO>> listByName(@RequestParam("nome") String nome) {
        return new ResponseEntity<>(pessoaService.listByName(nome), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id,
                         @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception {
        return new ResponseEntity<>(pessoaService.update(id, pessoaAtualizar), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }
}

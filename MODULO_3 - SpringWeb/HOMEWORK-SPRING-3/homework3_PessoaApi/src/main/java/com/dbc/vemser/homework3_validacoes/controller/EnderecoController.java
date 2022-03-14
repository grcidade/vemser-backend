package com.dbc.vemser.homework3_validacoes.controller;

import com.dbc.vemser.homework3_validacoes.entity.Endereco;
import com.dbc.vemser.homework3_validacoes.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
@Validated
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> list(){
        return new ResponseEntity<>(enderecoService.listarEnderecos(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{idEndereco}")
    public ResponseEntity<Endereco> getEndereco(@PathVariable("idEndereco") Integer id) throws Exception {
        return new ResponseEntity<>(enderecoService.getByIdEndereco(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public ResponseEntity<List<Endereco>> getEnderecoByPessoa(@PathVariable("idPessoa") Integer id) throws Exception {
        return new ResponseEntity<>(enderecoService.getByIdPessoa(id), HttpStatus.ACCEPTED);
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<Endereco> postEndereco(@PathVariable("idPessoa") Integer id,
                                 @Valid @RequestBody Endereco endereco) throws Exception {
        return new ResponseEntity<>(enderecoService.criarEndereco(id, endereco), HttpStatus.CREATED);
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<Endereco> updateEndereco(@PathVariable("idEndereco") Integer id,
                                   @Valid @RequestBody Endereco endereco) throws Exception {
        return new ResponseEntity<>(enderecoService.editarEndereco(id, endereco), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.deletarEndereco(id);
    }

}

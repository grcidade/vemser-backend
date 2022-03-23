package com.dbc.vemser.pessoa_api.controller;

import com.dbc.vemser.pessoa_api.dto.PessoaCreateDTO;
import com.dbc.vemser.pessoa_api.dto.PessoaDTO;
import com.dbc.vemser.pessoa_api.dto.PessoaDTOComContatos;
import com.dbc.vemser.pessoa_api.dto.PessoaDTOComEnderecos;
import com.dbc.vemser.pessoa_api.entity.PessoaEntity;
import com.dbc.vemser.pessoa_api.repository.PessoaRepository;
import com.dbc.vemser.pessoa_api.service.PessoaService;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiResponse;

import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
@Validated
@RequiredArgsConstructor
public class PessoaController {


    private final PessoaService pessoaService;
    private final PessoaRepository pessoaRepository;


    @PostMapping // localhost:8080/pessoa
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) throws Exception {
        return new ResponseEntity<>(pessoaService.create(pessoa), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Retorna uma lista de pessoas")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Retorna a lista de pessoas"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping // localhost:8080/pessoa
    public ResponseEntity<List<PessoaDTO>> list() {
        return new ResponseEntity<>(pessoaService.list(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/getByNome")
    public List<PessoaEntity> getByNome(@RequestParam(value = "name", required = true) String name){
        return pessoaRepository.findByNomeContainingIgnoreCase(name);
    }

    @GetMapping("/getByCpf")
    public List<PessoaEntity> listByCpf(@RequestParam("cpf") String cpf) {
        return pessoaRepository.findByCpfContains(cpf);
    }

    @GetMapping("/getByDataNascimento")
    public List<PessoaEntity> listByData(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
                                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
        return pessoaRepository.findByDataNascimentoBetween(dataInicial, dataFinal);
    }

    @GetMapping("/getListPessoasComContatos")
    public List<PessoaDTOComContatos> listarPessoasComContatos(@RequestParam(value = "id", required = false) Integer id) throws Exception {
        return pessoaService.listarPessoasComContatos(id);
    }

    @GetMapping("/getListPessoasComEnderecos")
    public List<PessoaDTOComEnderecos> listarPessoasComEnderecos(@RequestParam(value = "id", required = false) Integer id) throws Exception {
        return pessoaService.listarPessoasComEnderecos(id);
    }

    @ApiOperation(value = "Atualizar uma pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualizou a PessoaEntity"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id,
                                            @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception {
        return new ResponseEntity<>(pessoaService.update(id, pessoaAtualizar), HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Deleta uma pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "PessoaEntity deletada"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }
}

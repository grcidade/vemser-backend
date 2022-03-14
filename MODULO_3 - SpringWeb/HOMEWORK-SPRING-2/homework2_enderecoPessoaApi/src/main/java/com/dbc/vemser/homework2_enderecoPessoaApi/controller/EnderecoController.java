package com.dbc.vemser.homework2_enderecoPessoaApi.controller;

import com.dbc.vemser.homework2_enderecoPessoaApi.entity.Endereco;
import com.dbc.vemser.homework2_enderecoPessoaApi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> list(){
        return enderecoService.listarEnderecos();
    }

    @GetMapping("/{idEndereco}")
    public Endereco getEndereco(@PathVariable("idEndereco") Integer id) throws Exception {
        return enderecoService.getByIdEndereco(id);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> getEnderecoByPessoa(@PathVariable("idPessoa") Integer id) throws Exception {
        return enderecoService.getByIdPessoa(id);
    }

    @PostMapping("/{idPessoa}")
    public Endereco postEndereco(@PathVariable("idPessoa") Integer id,
                                 @RequestBody Endereco endereco){
        return enderecoService.criarEndereco(id, endereco);
    }

    @PutMapping("/{idEndereco}")
    public Endereco updateEndereco(@PathVariable("idEndereco") Integer id,
                                   @RequestBody Endereco endereco) throws Exception {
        return enderecoService.editarEndereco(id, endereco);
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id){
        enderecoService.deletarEndereco(id);
    }

}

package com.dbc.vemser.pessoa_api.controller;

import com.dbc.vemser.pessoa_api.dto.EnderecoCreateDTO;
import com.dbc.vemser.pessoa_api.dto.EnderecoDTO;
import com.dbc.vemser.pessoa_api.entity.EnderecoEntity;
import com.dbc.vemser.pessoa_api.repository.EnderecoRepository;
import com.dbc.vemser.pessoa_api.service.EnderecoService;
import io.swagger.models.auth.In;
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
    private EnderecoService enderecoService;
    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> list(){
        return new ResponseEntity<>(enderecoService.listarEnderecos(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> getEndereco(@PathVariable("idEndereco") Integer id) throws Exception {
        return new ResponseEntity<>(enderecoService.getByIdEndereco(id), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<EnderecoDTO> postEndereco(@Valid @RequestBody EnderecoCreateDTO endereco,
                                                    @RequestParam("idPessoa") Integer idPessoa) throws Exception {
        return new ResponseEntity<>(enderecoService.criarEndereco(idPessoa ,endereco), HttpStatus.CREATED);
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> updateEndereco(@PathVariable("idEndereco") Integer id,
                                   @Valid @RequestBody EnderecoCreateDTO endereco) throws Exception {
        return new ResponseEntity<>(enderecoService.editarEndereco(id, endereco), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.deletarEndereco(id);
    }

    @GetMapping("/byPais")
    public List<EnderecoEntity>findByPais(@RequestParam("pais") String pais){
        return enderecoRepository.findEnderecoByPais(pais);
    }

    @GetMapping("/byIdPessoa")
    public List<EnderecoEntity> findByIdPessoa(@RequestParam("id") Integer id){
        return enderecoRepository.findByIdPessoa(id);
    }

    @GetMapping("/byCidadeOuPais")
    public List<EnderecoEntity> findByCidadeOuPais(@RequestParam("cidade") String cidade, @RequestParam("pais") String pais){
        return enderecoRepository.findEnderecosPorCidadeOuPais(cidade, pais);
    }

    @GetMapping("/withouComplement")
    public List<EnderecoEntity> ListWithNoComplement(){
        return enderecoRepository.findWithNoComplement();
    }

}

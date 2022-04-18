package com.dbc.vemser.pessoa_api.dto;

import lombok.Data;

import java.util.List;

@Data
public class PessoaDTOComContatosEEnderecos extends PessoaDTO{

    private Integer idPessoa;
    private List<EnderecoDTO> enderecos;
    private List<ContatoDTO> contatos;

}

package com.dbc.vemser.pessoa_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PessoaDTOComContatos {

    private Integer idPessoa;
    private List<ContatoDTO> contatos;
}

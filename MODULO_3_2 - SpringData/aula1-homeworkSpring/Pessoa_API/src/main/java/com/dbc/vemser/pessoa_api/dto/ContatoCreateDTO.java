package com.dbc.vemser.pessoa_api.dto;

import com.dbc.vemser.pessoa_api.entity.TipoContato;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ContatoCreateDTO {

    private Integer idPessoa;

    @NotNull
    private TipoContato tipoContato;

    @NotEmpty
    @Size(min = 5, max = 13)
    private String numero;

    @NotEmpty
    private String descricao;

}

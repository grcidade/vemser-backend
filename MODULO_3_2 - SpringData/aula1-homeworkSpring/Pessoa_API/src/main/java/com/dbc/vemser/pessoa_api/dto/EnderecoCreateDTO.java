package com.dbc.vemser.pessoa_api.dto;

import com.dbc.vemser.pessoa_api.entity.TipoEndereco;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EnderecoCreateDTO {

    private String complemento;
    @NotEmpty
    @Size(max = 250)
    private String logradouro;
    @NotEmpty
    private String numero;
    @NotEmpty
    @Size(max = 8)
    private String cep;
    @NotEmpty
    @Size(max = 250)
    private String cidade;
    @NotEmpty
    private String estado;
    @NotEmpty
    private String pais;
    @NotNull
    private TipoEndereco tipo;

}

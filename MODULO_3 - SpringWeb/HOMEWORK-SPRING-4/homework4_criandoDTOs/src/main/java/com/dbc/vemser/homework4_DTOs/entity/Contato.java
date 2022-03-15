package com.dbc.vemser.homework4_DTOs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Contato {

    private Integer idContato;
    private Integer idPessoa;
    private String tipoContato;
    private String numero;
    private String descricao;
}

package com.dbc.vemser.homework4_DTOs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pessoa {

    private Integer idPessoa;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;

}

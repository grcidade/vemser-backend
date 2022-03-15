package com.dbc.vemser.homework4_DTOs.dto;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {

    @NotBlank
    @Size(min = 2, max = 20, message = "Tamanho Invalido")
    private String nome;
    @Past
    @NotNull
    private LocalDate dataNascimento;
    @CPF
    private String cpf;

}

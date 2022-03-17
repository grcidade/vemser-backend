package com.dbc.vemser.homework5_servicoEmail.dto;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
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
    @Email
    private String email;

}

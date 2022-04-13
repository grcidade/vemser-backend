package com.dbc.kafka.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutorDTO {

    private String usuario;

    private String mensagem;

    private LocalDateTime dataCriacao;

}

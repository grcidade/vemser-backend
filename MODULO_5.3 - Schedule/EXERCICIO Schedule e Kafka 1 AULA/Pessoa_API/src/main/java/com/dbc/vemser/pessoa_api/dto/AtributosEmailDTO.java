package com.dbc.vemser.pessoa_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtributosEmailDTO {

    private String destinatario;
    private String assunto;
    private String texto;

}

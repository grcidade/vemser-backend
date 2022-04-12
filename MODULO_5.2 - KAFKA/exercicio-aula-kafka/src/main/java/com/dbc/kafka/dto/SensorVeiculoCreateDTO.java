package com.dbc.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SensorVeiculoCreateDTO {

    private Double velocidade;
    private Integer rotacao;
    private boolean sensorFrenagem;

}

package com.dbc.kafka.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "sensor_veiculo")
public class SensorVeiculo {

    @Id
    private String id;

    private LocalDateTime dataLeitura;

    private Double velocidade;

    private Integer rotacao;

    private boolean sensorFrenagem;

}

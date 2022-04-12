package com.dbc.kafka.controller;

import com.dbc.kafka.dto.SensorVeiculoDTO;
import com.dbc.kafka.service.SensorVeiculoService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/consumer")
@RequiredArgsConstructor
@Api(value = "Consumer API", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Consumer API"})
public class ConsumerController{
    private final SensorVeiculoService sensorVeiculoService;

    @GetMapping
    public List<SensorVeiculoDTO> getAll(){
        return sensorVeiculoService.getAll();
    }

    @GetMapping("/quantidade")
    public String getQuantidade(){
        Long quantidade = sensorVeiculoService.quantidadeLeituras();
        return "Quantidade de leituras: " + quantidade;
    }

    @GetMapping("/velociade-media")
    public Double getVelocidadeMedia(){
        return sensorVeiculoService.velocidadeMedia();
    }

    @GetMapping("/rotacao-media")
    public Double getRotacaoMedia(){
        return sensorVeiculoService.rotacaoMedia();
    }


}

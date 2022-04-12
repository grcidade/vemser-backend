package com.dbc.kafka.controller;

import com.dbc.kafka.dto.SensorVeiculoCreateDTO;
import com.dbc.kafka.service.ProdutorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
@Api(value = "Producer API", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Producer API"})
public class ProdutoController {

    private final ProdutorService produtorService;

    @PostMapping("/enviar")
    public void enviarSensores(@RequestBody SensorVeiculoCreateDTO sensorVeiculoCreateDTO) throws JsonProcessingException {
        produtorService.sendSensores(sensorVeiculoCreateDTO);
    }

}

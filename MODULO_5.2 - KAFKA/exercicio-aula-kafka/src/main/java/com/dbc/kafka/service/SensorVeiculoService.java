package com.dbc.kafka.service;

import com.dbc.kafka.dto.SensorVeiculoDTO;
import com.dbc.kafka.entity.SensorVeiculo;
import com.dbc.kafka.repository.SensorVeiculoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorVeiculoService {

    private final SensorVeiculoRepository sensorVeiculoRepository;
    private final ObjectMapper objectMapper;

    public void saveSensor(SensorVeiculoDTO sensorVeiculoDTO){
        sensorVeiculoRepository.save(objectMapper.convertValue(sensorVeiculoDTO, SensorVeiculo.class));
    }

    public List<SensorVeiculoDTO> getAll(){
        return sensorVeiculoRepository.findAll().stream().map(sensorVeiculo -> objectMapper.convertValue(sensorVeiculo, SensorVeiculoDTO.class)).toList();
    }

    public Long quantidadeLeituras(){
        return sensorVeiculoRepository.count();
    }

    public Double velocidadeMedia(){
        Double velocidade = sensorVeiculoRepository.findVelocidadeTotal();
        Long quantidade = sensorVeiculoRepository.count();
        return velocidade/quantidade;
    }

    public Double rotacaoMedia(){
        Double rotacao = sensorVeiculoRepository.findRotacaoTotal();
        Long quantidade = sensorVeiculoRepository.count();
        return rotacao/quantidade;
    }

}

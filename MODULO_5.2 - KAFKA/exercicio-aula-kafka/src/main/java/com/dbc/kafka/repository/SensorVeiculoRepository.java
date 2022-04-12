package com.dbc.kafka.repository;

import com.dbc.kafka.entity.SensorVeiculo;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorVeiculoRepository extends MongoRepository<SensorVeiculo, String> {

    @Aggregation(pipeline = {
            "{'$group':{ '_id': 'null', 'sum' : {'$sum': $velocidade} }}"
    })
    Double findVelocidadeTotal();

    @Aggregation(pipeline = {
            "{'$group':{ '_id': 'null', 'sum' : {'$sum': $rotacao} }}"
    })
    Double findRotacaoTotal();

}

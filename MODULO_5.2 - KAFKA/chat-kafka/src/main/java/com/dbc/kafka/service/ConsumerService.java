package com.dbc.kafka.service;

import com.dbc.kafka.dto.ProdutorDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {

    private static final String GROUP_ID = "guilherme";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private final ObjectMapper objectMapper;

    @KafkaListener(
            topics = "chat-geral",
            groupId = GROUP_ID,
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "geral")
    public void consumeChatGeral(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        ProdutorDTO mensagemRecebida = objectMapper.readValue(message, ProdutorDTO.class);
        String dataFormatada = mensagemRecebida.getDataCriacao().format(formatter);
        System.out.println("=======================================================" + "\n" +
                dataFormatada + " [" + mensagemRecebida.getUsuario() + "]: " + mensagemRecebida.getMensagem() + "\n" +
                "=======================================================");
//        log.info("#### offset -> '{}' key -> '{}' -> Consumed Object message -> '{}'  ", offset, key, message);
    }

    @KafkaListener(
            topics = "chat-guilherme",
            groupId = GROUP_ID,
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "private")
    public void consumeChatPrivado(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        ProdutorDTO mensagemRecebida = objectMapper.readValue(message, ProdutorDTO.class);
        String dataFormatada = mensagemRecebida.getDataCriacao().format(formatter);
        System.out.println("=======================================================" + "\n" +
                dataFormatada + " [" + mensagemRecebida.getUsuario() + "] (privada): " + mensagemRecebida.getMensagem() + "\n" +
                "=======================================================");
//        log.info("#### offset -> '{}' key -> '{}' -> Consumed Object message -> '{}'  ", offset, key, message);
    }


}

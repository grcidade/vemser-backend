package com.dbc.kafka.service;

import com.dbc.kafka.dto.ProdutorDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private static final String TOPIC = "chat-marcar-churrasco";

    private static final String GROUP_ID = "guilherme";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private final ObjectMapper objectMapper;

    @KafkaListener(
            groupId = GROUP_ID,
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "geral",
            topicPartitions = {@TopicPartition(topic = TOPIC, partitions = {"0"})})
    public void consumeChatGeral(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        ProdutorDTO mensagemRecebida = objectMapper.readValue(message, ProdutorDTO.class);
        String dataFormatada = mensagemRecebida.getDataCriacao().format(formatter);
        System.out.println("=======================================================" + "\n" +
                ANSI_BLUE+dataFormatada + " [" +ANSI_BLUE+ mensagemRecebida.getUsuario() + "]: " +ANSI_YELLOW+ mensagemRecebida.getMensagem() +ANSI_RESET+ "\n" +
                "=======================================================");
    }

    @KafkaListener(
            groupId = GROUP_ID,
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "private",
            topicPartitions = {@TopicPartition(topic = TOPIC, partitions = {"6"})})
    public void consumeChatPrivado(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        ProdutorDTO mensagemRecebida = objectMapper.readValue(message, ProdutorDTO.class);
        String dataFormatada = mensagemRecebida.getDataCriacao().format(formatter);
        System.out.println("=======================================================" + "\n" +
                ANSI_BLUE+dataFormatada + " [" +ANSI_BLUE+ mensagemRecebida.getUsuario() + "]" +ANSI_RED+" (privada): " +ANSI_YELLOW+ mensagemRecebida.getMensagem() +ANSI_RESET+ "\n" +
                "=======================================================");
    }


}

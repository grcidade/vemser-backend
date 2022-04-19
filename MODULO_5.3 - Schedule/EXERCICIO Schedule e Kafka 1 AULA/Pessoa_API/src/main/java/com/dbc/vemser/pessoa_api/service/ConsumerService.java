package com.dbc.vemser.pessoa_api.service;

import com.dbc.vemser.pessoa_api.dto.AtributosEmailDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {

    private static final String GROUP_ID = "guilherme";

    private final ObjectMapper objectMapper;
    private final EnvioEmailService envioEmailService;


    @KafkaListener(
            topics = "envio-email",
            groupId = GROUP_ID,
            containerFactory = "listenerContainerFactory")
    public void consumer(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        AtributosEmailDTO atributosEmailDTO = objectMapper.readValue(message, AtributosEmailDTO.class);
        envioEmailService.addEmail(atributosEmailDTO);
        log.info("#### offset -> '{}' key -> '{}' -> Consumed Object message -> '{}'  ", offset, key, message);
    }




}

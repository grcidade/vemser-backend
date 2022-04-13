package com.dbc.kafka.service;

import com.dbc.kafka.dto.ProdutorDTO;
import com.dbc.kafka.enums.Chats;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProdutorService {

    private static final String MEU_USUARIO = "guilherme";
    private static final LocalDateTime DATA_ATUAL = LocalDateTime.now();


    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String,String> kafkaTemplate;

    public void enviarMensagem(String mensagem, List<Chats> chatsList) throws JsonProcessingException {
        ProdutorDTO produtorDTO = ProdutorDTO.builder()
                .usuario(MEU_USUARIO)
                .mensagem(mensagem)
                .dataCriacao(DATA_ATUAL).build();
        String payload = objectMapper.writeValueAsString(produtorDTO);
        for(Chats topico : chatsList){
            send(payload, topico.getChat());
        }
    }

    private void send(String mensagem, String topico) {

        Message<String> message = MessageBuilder.withPayload(mensagem)
                .setHeader(KafkaHeaders.TOPIC, topico)
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())
                .build();

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(message);

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult result) {
                log.info(" Log enviado para o kafka com o texto: {}, e para o chat: {}", mensagem, topico);
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error(" Erro ao publicar duvida no kafka com a mensagem: {}", mensagem, ex);
            }
        });
    }
}

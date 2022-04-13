package com.dbc.kafka.controller;

import com.dbc.kafka.enums.Chats;
import com.dbc.kafka.service.ProdutorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
@Api(value = "Producer API", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Producer API"})
public class ProdutoController {

    private final ProdutorService produtorService;

    @PostMapping("/enviarMensagem")
    public void enviarMensagem(@RequestParam String mensagem,
                               @RequestParam List<Chats> chatsList) throws JsonProcessingException {
        produtorService.enviarMensagem(mensagem, chatsList);
    }

}

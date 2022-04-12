package com.dbc.kafka.controller;

import com.dbc.kafka.service.ProdutorService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
@Api(value = "Producer API", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Producer API"})
public class ProdutoController implements ProdutoAPI{

    private final ProdutorService produtorService;

    @PostMapping("/enviar")
    public void enviar(String mensagem) {
        produtorService.enviarMensagem(mensagem);
    }

}

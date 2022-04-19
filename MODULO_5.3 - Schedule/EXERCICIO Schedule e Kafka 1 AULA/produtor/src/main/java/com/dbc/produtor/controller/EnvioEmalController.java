package com.dbc.produtor.controller;


import com.dbc.produtor.dto.AtributosEmailDTO;
import com.dbc.produtor.service.ProdutorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EnvioEmalController {

    private final ProdutorService produtorService;

    @PostMapping("/send")
    public void sendEmail(@RequestBody AtributosEmailDTO atributosEmailDTO) throws JsonProcessingException {
        produtorService.enviarEmail(atributosEmailDTO);
    }

}

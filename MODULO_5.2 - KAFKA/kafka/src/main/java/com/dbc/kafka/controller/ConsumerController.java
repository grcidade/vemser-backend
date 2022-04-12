package com.dbc.kafka.controller;

import com.dbc.kafka.service.ConsumerService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
@Api(value = "Consumer API", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Consumer API"})
public class ConsumerController implements ConsumerAPI{
    private final ConsumerService consumerService;

    @GetMapping
    public HashMap<Long,String> getMessages(){
        return consumerService.getMessages();
    }

}

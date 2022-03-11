package com.dbc.vemser.homework_pessoa_contato_api.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
 public class PropertiReader {

    @Value("${ambiente}")
    private String ambiente;

    public String getAmbiente(){
        return "Ambiente: " + ambiente;
    }
}

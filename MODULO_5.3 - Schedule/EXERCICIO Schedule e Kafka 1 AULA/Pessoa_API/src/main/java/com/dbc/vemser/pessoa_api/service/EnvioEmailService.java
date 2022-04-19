package com.dbc.vemser.pessoa_api.service;

import com.dbc.vemser.pessoa_api.dto.AtributosEmailDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EnvioEmailService {

    private final EmailService emailService;

    private List<AtributosEmailDTO> emailsParaMandar = new ArrayList<>();

    public void addEmail(AtributosEmailDTO atributosEmailDTO){
        emailsParaMandar.add(atributosEmailDTO);
    }

    @Scheduled(fixedDelay = 300000)
    public void sendEmails(){
        if(!emailsParaMandar.isEmpty()){
            emailService.sendSimpleMessageKafka(emailsParaMandar.get(0));
            emailsParaMandar.remove(0);
        }else {
            log.info("Lista Vazia");
        }
    }


}

package com.dbc.vemser.pessoa_api.service;

import com.dbc.vemser.pessoa_api.client.DadosPessoaisClient;
import com.dbc.vemser.pessoa_api.dto.DadosPessoaisDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DadosPessoaisService {

    @Autowired
    private DadosPessoaisClient client;

    public List<DadosPessoaisDTO> listDadosPessoais() {
        return client.getAll();
    }

    public DadosPessoaisDTO create(DadosPessoaisDTO dadosPessoaisDTO) throws Exception {
        return client.post(dadosPessoaisDTO);
    }

    public DadosPessoaisDTO update(String cpf, DadosPessoaisDTO dto) throws Exception {
        return client.put(cpf, dto);
    }

    public DadosPessoaisDTO getByCpf(String cpf){
        return client.get(cpf);
    }

    public void delete(String cpf){
        client.delete(cpf);
    }

}

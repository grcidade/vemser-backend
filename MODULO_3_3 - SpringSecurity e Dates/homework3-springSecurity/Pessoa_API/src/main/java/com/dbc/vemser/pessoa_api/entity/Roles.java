package com.dbc.vemser.pessoa_api.entity;

import io.swagger.models.auth.In;

import java.util.Arrays;

public enum Roles {
    
    ADMIN(1,"Administradores"),
    USUARIO(2,"Cadastro"),
    MARKETING(3,"Marketing");

    private final Integer idGrupo;
    private final String descricao;

    Roles(Integer idGrupo, String descricao) {
        this.idGrupo = idGrupo;
        this.descricao = descricao;
    }

    public Integer getRole(){
        return idGrupo;
    }

    public String getDescricao(){
        return descricao;
    }

    public static Roles ofTipo(Integer idGrupo){
        return Arrays.stream(Roles.values())
                .filter(idDoGrupo -> idDoGrupo.getRole().equals(idGrupo))
                .findFirst()
                .get();
    }
}

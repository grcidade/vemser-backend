package com.dbc.kafka.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
public interface ProdutoAPI {

    @ApiOperation(value = "Mandar mensagem")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Tudo certo"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    void enviar(String mensagem);


}

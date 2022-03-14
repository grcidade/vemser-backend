package com.dbc.vemser.homework3_validacoes.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Endereco {

    private Integer idEndereco;
    private Integer idPessoa;
    @NotEmpty
    @Size(max = 250)
    private String logradouro;
    @NotEmpty
    private String numero;
    @NotEmpty
    @Size(max = 8)
    private String cep;
    @NotEmpty
    @Size(max = 250)
    private String cidade;
    @NotEmpty
    private String estado;
    @NotEmpty
    private String pais;
    @NotNull
    private String tipo;

    public Endereco(){
    }

    public Endereco(Integer idEndereco, Integer idPessoa, String logradouro, String numero, String cep, String cidade, String estado, String pais, String tipo) {
        this.idEndereco = idEndereco;
        this.idPessoa = idPessoa;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "idEndereco=" + idEndereco +
                ", idPessoa=" + idPessoa +
                ", logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", bairro='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", pais='" + pais + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}

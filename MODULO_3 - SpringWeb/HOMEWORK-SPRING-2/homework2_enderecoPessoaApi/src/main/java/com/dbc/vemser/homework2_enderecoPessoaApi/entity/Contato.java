package com.dbc.vemser.homework2_enderecoPessoaApi.entity;

public class Contato {

    private Integer idContato;
    private Integer idPessoa;
    private String tipoContato;
    private Integer numero;
    private String descricao;

    @SuppressWarnings("unused")
    public Contato(){
    }

    public Contato(Integer idContato, Integer idPessoa, String tipoContato, Integer numero, String descricao) {
        this.idContato = idContato;
        this.idPessoa = idPessoa;
        this.tipoContato = tipoContato;
        this.numero = numero;
        this.descricao = descricao;
    }

    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(String tipoContato) {
        this.tipoContato = tipoContato;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "idContato=" + idContato +
                ", idPessoa=" + idPessoa +
                ", tipoContato='" + tipoContato + '\'' +
                ", numero=" + numero +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}

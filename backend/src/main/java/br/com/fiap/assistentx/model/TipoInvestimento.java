package br.com.fiap.assistentx.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_ax_investimento_tipo")
public class TipoInvestimento {
    @Id
    @Column(name = "id_investimento_tipo")
    private Integer id;

    @Column(name = "ds_tipo")
    private String nome;

    @Column(name = "ds_classificacao")
    private String classificacao;

    @Column(name = "ds_valorizacao")
    private String valorizacao;

    @Column(name = "ds_pagamento")
    private String pagamento;

    public TipoInvestimento() {
    }

    public TipoInvestimento(Integer id, String nome, String classificacao, String pagamento, String valorizacao) {
        this.id = id;
        this.nome = nome;
        this.classificacao = classificacao;
        this.valorizacao = valorizacao;
        this.pagamento = pagamento;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getValorizacao() {
        return valorizacao;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public void setValorizacao(String valorizacao) {
        this.valorizacao = valorizacao;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }
}

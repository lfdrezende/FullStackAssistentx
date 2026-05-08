package br.com.fiap.assistentx.dto;

import java.time.OffsetDateTime;


public class InvestimentoDTO {

    private Integer investimentoId;
    private Integer usuarioId;
    private Integer tipoInvestimentoId;
    private Double valorInicial;
    private Double valorAtual;
    private Double ultimaMensalidade;
    private Double jurosEstimados;
    private String tipoInvestimento;
    private String classificacao;
    private OffsetDateTime dataInicio;


    public InvestimentoDTO(){}

    //construtor do post
    public InvestimentoDTO(
            Integer usuarioId,
            Integer tipoInvestimentoId,
            Double valorInicial,
            Double valorAtual,
            OffsetDateTime dataInicio
    ){
        this(
                null,
                usuarioId,
                tipoInvestimentoId,
                valorInicial,
                valorAtual,
                null,
                null,
                null,
                null,
                dataInicio
        );
    }

    //construtor do update
    public InvestimentoDTO(
            Integer investimentoId,
            Integer usuarioId,
            Integer tipoInvestimentoId,
            Double valorInicial,
            Double valorAtual,
            OffsetDateTime dataInicio
    ){
        this(
                investimentoId,
                usuarioId,
                tipoInvestimentoId,
                valorInicial,
                valorAtual,
                null,
                null,
                null,
                null,
                dataInicio
        );
    }

    //construtor do get
    public InvestimentoDTO(
            Integer investimentoId,
            Integer usuarioId,
            Integer tipoInvestimentoId,
            Double valorInicial,
            Double valorAtual,
            Double ultimaMensalidade,
            Double jurosEstimados,
            String tipoInvestimento,
            String classificacao,
            OffsetDateTime dataInicio
    ) {
        this.investimentoId = investimentoId;
        this.usuarioId = usuarioId;
        this.tipoInvestimentoId = tipoInvestimentoId;
        this.valorInicial = valorInicial;
        this.valorAtual = valorAtual;
        this.ultimaMensalidade = ultimaMensalidade;
        this.jurosEstimados = jurosEstimados;
        this.tipoInvestimento = tipoInvestimento;
        this.classificacao = classificacao;
        this.dataInicio = dataInicio;
    }

    public Integer getInvestimentoId() {
        return investimentoId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public Integer getTipoInvestimentoId() {
        return tipoInvestimentoId;
    }

    public Double getValorInicial() {
        return valorInicial;
    }

    public Double getValorAtual() {
        return valorAtual;
    }

    public Double getUltimaMensalidade() {
        return ultimaMensalidade;
    }

    public Double getJurosEstimados() {
        return jurosEstimados;
    }

    public String getTipoInvestimento() {
        return tipoInvestimento;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public OffsetDateTime getDataInicio() {
        return dataInicio;
    }

    public void setInvestimentoId(Integer investimentoId) {
        this.investimentoId = investimentoId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setTipoInvestimentoId(Integer tipoInvestimentoId) {
        this.tipoInvestimentoId = tipoInvestimentoId;
    }

    public void setValorInicial(Double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public void setValorAtual(Double valorAtual) {
        this.valorAtual = valorAtual;
    }

    public void setUltimaMensalidade(Double ultimaMensalidade) {
        this.ultimaMensalidade = ultimaMensalidade;
    }

    public void setJurosEstimados(Double jurosEstimados) {
        this.jurosEstimados = jurosEstimados;
    }

    public void setTipoInvestimento(String tipoInvestimento) {
        this.tipoInvestimento = tipoInvestimento;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public void setDataInicio(OffsetDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }
}



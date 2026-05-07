package br.com.fiap.assistentx.dto;

import br.com.fiap.assistentx.model.Investimento;
import java.time.OffsetDateTime;


public class InvestimentoDTO {

    private final Integer investimentoId;
    private final Integer usuarioId;
    private final Integer tipoInvestimentoId;
    private final Double valorInicial;
    private final Double valorAtual;
    private final Double ultimaReceitaMensal;
    private final Double jurosEstimados;
    private final String tipoInvestimento;
    private final String classificacao;
    private final OffsetDateTime dataInicio;

    public InvestimentoDTO(
            Integer investimentoId,
            Integer usuarioId,
            Integer tipoInvestimentoId,
            Double valorInicial,
            Double valorAtual,
            Double ultimaReceitaMensal,
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
        this.ultimaReceitaMensal = ultimaReceitaMensal;
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

    public Double getUltimaReceitaMensal() {
        return ultimaReceitaMensal;
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

}



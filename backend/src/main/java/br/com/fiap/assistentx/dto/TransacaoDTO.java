package br.com.fiap.assistentx.dto;

import br.com.fiap.assistentx.model.Investimento;
import br.com.fiap.assistentx.model.TipoInvestimento;

import java.time.OffsetDateTime;

public class InvestimentoDTO {

    private Integer investimentoId;
    private Integer usuarioId;
    private Integer tipoInvestimentoId;
    private Double valorInicial;
    private Double valorAtual;
    private Double ultimaReceitaMensal;
    private Double jurosEstimados;
    private String tipoInvestimento;
    private String classificacao;
    private OffsetDateTime dataInicio;

    public Integer getInvestimentoId() {
        return investimentoId;
    }

    public void setInvestimentoId(Integer investimentoId) {
        this.investimentoId = investimentoId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Double getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(Double valorAtual) {
        this.valorAtual = valorAtual;
    }

    public Double getUltimaReceitaMensal() {
        return ultimaReceitaMensal;
    }

    public void setUltimaReceitaMensal(Double ultimaReceitaMensal) {
        this.ultimaReceitaMensal = ultimaReceitaMensal;
    }

    public Double getJurosEstimados() {
        return jurosEstimados;
    }

    public void setJurosEstimados(Double jurosEstimados) {
        this.jurosEstimados = jurosEstimados;
    }

    public String getTipoInvestimento() {
        return tipoInvestimento;
    }

    public void setTipoInvestimento(String tipoInvestimento) {
        this.tipoInvestimento = tipoInvestimento;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public OffsetDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(OffsetDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Integer getTipoInvestimentoId() {
        return tipoInvestimentoId;
    }

    public void setTipoInvestimentoId(Integer tipoInvestimentoId) {
        this.tipoInvestimentoId = tipoInvestimentoId;
    }

    public static InvestimentoDTO toDTO(Investimento investimento){

        InvestimentoDTO dto = new InvestimentoDTO();

        dto.setUsuarioId(investimento.getUsuario().getId());
        dto.setInvestimentoId(investimento.getId());
        dto.setTipoInvestimentoId(investimento.getTipo().getId());
        dto.setValorInicial(investimento.getValor());
        dto.setValorAtual(investimento.getValorAtual());
        dto.setUltimaReceitaMensal(investimento.getUltimaReceitaMensal());
        dto.setJurosEstimados(investimento.getJurosEstimados());
        dto.setTipoInvestimento(investimento.getTipo().getNome());
        dto.setClassificacao(investimento.getTipo().getClassificacao());
        dto.setDataInicio(investimento.getDataHora());

        return dto;
    }

}

package br.com.fiap.assistentx.dto;

import java.util.List;

public class PatrimonioResumoDTO {
    private double valorInicialTotal;
    private double valorAtualTotal;
    private double jurosEstimados;
    private double ultimaMensalidade;

    private List<ClassificacaoResumoDTO> classificacoes;

    public double getValorInicialTotal() {
        return valorInicialTotal;
    }

    public void setValorInicialTotal(double valorInicialTotal) {
        this.valorInicialTotal = valorInicialTotal;
    }

    public double getValorAtualTotal() {
        return valorAtualTotal;
    }

    public void setValorAtualTotal(double valorAtualTotal) {
        this.valorAtualTotal = valorAtualTotal;
    }

    public double getJurosEstimados() {
        return jurosEstimados;
    }

    public void setJurosEstimados(double jurosEstimados) {
        this.jurosEstimados = jurosEstimados;
    }

    public double getUltimaMensalidade() {
        return ultimaMensalidade;
    }

    public void setUltimaMensalidade(double ultimaMensalidade) {
        this.ultimaMensalidade = ultimaMensalidade;
    }

    public List<ClassificacaoResumoDTO> getClassificacoes() {
        return classificacoes;
    }

    public void setClassificacoes(List<ClassificacaoResumoDTO> classificacoes) {
        this.classificacoes = classificacoes;
    }
}

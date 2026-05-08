package br.com.fiap.assistentx.dto;

public class ResumoClassificacaoInvestimentoDTO {

    private String classificacao;

    private double valorInicialTotal;
    private double valorAtualTotal;
    private double jurosEstimados;
    private double ultimaMensalidade;

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

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
}
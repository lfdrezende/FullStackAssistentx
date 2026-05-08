package br.com.fiap.assistentx.dto;

public class ResumoOrigemTransacaoDTO {

    private Integer origemId;
    private String origemNome;
    private Double valorTotal;

    public Integer getOrigemId() {
        return origemId;
    }

    public void setOrigemId(Integer origemId) {
        this.origemId = origemId;
    }

    public String getOrigemNome() {
        return origemNome;
    }

    public void setOrigemNome(String origemNome) {
        this.origemNome = origemNome;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    // getters/setters
}

package br.com.fiap.assistentx.dto;

import java.util.List;

public class ResumoSaidasDTO {

    private Double valorTotalSaidas;

    private List<ResumoOrigemTransacaoDTO> origens;

    public Double getValorTotalSaidas() {
        return valorTotalSaidas;
    }

    public void setValorTotalSaidas(Double valorTotalSaidas) {
        this.valorTotalSaidas = valorTotalSaidas;
    }

    public List<ResumoOrigemTransacaoDTO> getOrigens() {
        return origens;
    }

    public void setOrigens(List<ResumoOrigemTransacaoDTO> origens) {
        this.origens = origens;
    }
}
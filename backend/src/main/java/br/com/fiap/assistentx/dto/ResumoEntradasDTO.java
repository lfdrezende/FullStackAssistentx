package br.com.fiap.assistentx.dto;

import java.util.List;

public class ResumoEntradasDTO {

    private Double valorTotalEntradas;

    private List<ResumoOrigemTransacaoDTO> origens;

    public Double getValorTotalEntradas() {
        return valorTotalEntradas;
    }

    public void setValorTotalEntradas(Double valorTotalEntradas) {
        this.valorTotalEntradas = valorTotalEntradas;
    }

    public List<ResumoOrigemTransacaoDTO> getOrigens() {
        return origens;
    }

    public void setOrigens(List<ResumoOrigemTransacaoDTO> origens) {
        this.origens = origens;
    }
}

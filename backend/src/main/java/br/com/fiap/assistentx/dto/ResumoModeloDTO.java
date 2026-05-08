package br.com.fiap.assistentx.dto;

import java.util.List;

public class ResumoModeloDTO {

    private Double orcamento;

    private List<ResumoCategoriaModeloDTO> categorias;

    public Double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Double orcamento) {
        this.orcamento = orcamento;
    }

    public List<ResumoCategoriaModeloDTO> getCategorias() {
        return categorias;
    }

    public void setCategorias(
            List<ResumoCategoriaModeloDTO> categorias
    ) {
        this.categorias = categorias;
    }
}

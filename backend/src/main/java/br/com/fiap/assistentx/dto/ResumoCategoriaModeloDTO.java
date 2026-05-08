package br.com.fiap.assistentx.dto;

public class ResumoCategoriaModeloDTO {

    private Integer categoriaId;
    private String categoriaNome;

    private Double percentualCategoria;

    private Double limite;

    private Double valorUtilizado;

    private Double sobra;

    private Double percentualUtilizado;

    private String status;

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getCategoriaNome() {
        return categoriaNome;
    }

    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }

    public Double getPercentualCategoria() {
        return percentualCategoria;
    }

    public void setPercentualCategoria(
            Double percentualCategoria
    ) {
        this.percentualCategoria = percentualCategoria;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public Double getValorUtilizado() {
        return valorUtilizado;
    }

    public void setValorUtilizado(Double valorUtilizado) {
        this.valorUtilizado = valorUtilizado;
    }

    public Double getSobra() {
        return sobra;
    }

    public void setSobra(Double sobra) {
        this.sobra = sobra;
    }

    public Double getPercentualUtilizado() {
        return percentualUtilizado;
    }

    public void setPercentualUtilizado(
            Double percentualUtilizado
    ) {
        this.percentualUtilizado = percentualUtilizado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

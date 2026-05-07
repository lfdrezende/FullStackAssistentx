package br.com.fiap.assistentx.model;


import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ModeloComCategoriaId implements Serializable {

    @Column(name = "id_modelo")
    private Integer modeloId;

    @Column(name = "id_categoria")
    private Integer categoriaId;

    public ModeloComCategoriaId() {}

    public ModeloComCategoriaId(Integer modeloId, Integer categoriaId) {
        this.modeloId = modeloId;
        this.categoriaId = categoriaId;
    }

    public Integer getModeloId() {
        return modeloId;
    }

    public void setModeloId(Integer modeloId) {
        this.modeloId = modeloId;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModeloComCategoriaId)) return false;

        ModeloComCategoriaId that = (ModeloComCategoriaId) o;

        return Objects.equals(modeloId, that.modeloId)
                && Objects.equals(categoriaId, that.categoriaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modeloId, categoriaId);
    }
}
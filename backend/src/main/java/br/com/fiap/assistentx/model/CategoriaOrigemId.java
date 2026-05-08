package br.com.fiap.assistentx.model;

import jakarta.persistence.*;
import java.util.Objects;
import java.io.Serializable;

@Embeddable
public class CategoriaOrigemId implements Serializable {

    @Column(name = "id_categoria")
    private Integer categoriaId;

    @Column(name = "id_origem")
    private Integer origemId;

    public CategoriaOrigemId() {}

    public CategoriaOrigemId(
            Integer categoriaId,
            Integer origemId
    ) {
        this.categoriaId = categoriaId;
        this.origemId = origemId;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Integer getOrigemId() {
        return origemId;
    }

    public void setOrigemId(Integer origemId) {
        this.origemId = origemId;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof CategoriaOrigemId))
            return false;

        CategoriaOrigemId that =
                (CategoriaOrigemId) o;

        return Objects.equals(
                categoriaId,
                that.categoriaId
        ) &&
                Objects.equals(
                        origemId,
                        that.origemId
                );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                categoriaId,
                origemId
        );
    }
}
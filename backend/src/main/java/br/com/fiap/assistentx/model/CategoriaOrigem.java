package br.com.fiap.assistentx.model;

import jakarta.persistence.*;

@Entity
@Table(name = "t_ax_categoria_origem")
public class CategoriaOrigem {

    @EmbeddedId
    private CategoriaOrigemId id;

    @ManyToOne
    @MapsId("categoriaId")
    @JoinColumn(name = "id_categoria")
    private CategoriaDoModelo categoria;

    @ManyToOne
    @MapsId("origemId")
    @JoinColumn(name = "id_origem")
    private OrigemTransacao origem;

    public CategoriaOrigemId getId() {
        return id;
    }

    public void setId(CategoriaOrigemId id) {
        this.id = id;
    }

    public CategoriaDoModelo getCategoria() {
        return categoria;
    }

    public void setCategoria(
            CategoriaDoModelo categoria
    ) {
        this.categoria = categoria;
    }

    public OrigemTransacao getOrigem() {
        return origem;
    }

    public void setOrigem(
            OrigemTransacao origem
    ) {
        this.origem = origem;
    }
}
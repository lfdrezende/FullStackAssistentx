package br.com.fiap.assistentx.model;

import jakarta.persistence.*;

@Entity
@Table(name = "t_ax_modelo_categoria")
public class ModeloComCategoria {

    @EmbeddedId
    private ModeloComCategoriaId id;

    @ManyToOne
    @MapsId("modeloId")
    @JoinColumn(name = "id_modelo")
    private Modelo modelo;

    @ManyToOne
    @MapsId("categoriaId")
    @JoinColumn(name = "id_categoria")
    private CategoriaDoModelo categoria;

    @Column(name = "vl_caracteristica")
    private Double valor;

    public CategoriaDoModelo getCategoria() {
        return categoria;
    }

    public Double getValor() {
        return valor;
    }

    public ModeloComCategoriaId getId() {
        return id;
    }

    public Modelo getModelo() {
        return modelo;
    }
}

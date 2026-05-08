package br.com.fiap.assistentx.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_ax_modelo")
public class Modelo {

    @Id
    @Column(name = "id_modelo")
    private Integer id;

    @Column(name = "nm_modelo")
    private String nome;

    @Column(name = "ds_modelo")
    private String descricao;

    @OneToMany(mappedBy = "modelo")
    private List<ModeloComCategoria> categorias;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getId() {
        return id;
    }

    public List<ModeloComCategoria> getCategorias() {
        return categorias;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}

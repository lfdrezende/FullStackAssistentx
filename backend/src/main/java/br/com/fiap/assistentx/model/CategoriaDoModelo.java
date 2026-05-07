package br.com.fiap.assistentx.model;

import jakarta.persistence.*;

@Entity
@Table(name = "t_ax_categoria")
public class CategoriaDoModelo {

    @Id
    @Column(name = "id_categoria")
    private Integer id;

    @Column(name = "nm_categoria")
    private String nome;

    @Column(name = "ds_categoria")
    private String descricao;

    public CategoriaDoModelo(){}

    public CategoriaDoModelo(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

}

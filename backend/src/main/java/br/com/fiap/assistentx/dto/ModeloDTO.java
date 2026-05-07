package br.com.fiap.assistentx.dto;

import java.util.List;

public class ModeloDTO {

    private Integer id;
    private String nome;
    private String descricao;

    private List<CategoriaDoModeloDTO> categorias;

    public ModeloDTO() {}

    public ModeloDTO(Integer id,
                     String nome,
                     String descricao,
                     List<CategoriaDoModeloDTO> categorias) {

        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.categorias = categorias;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<CategoriaDoModeloDTO> getCategorias() {
        return categorias;
    }
}
package br.com.fiap.assistentx.dto;

public class CategoriaDoModeloDTO {

    private Integer id;
    private String nome;
    private String descricao;
    private Double valor;

    public CategoriaDoModeloDTO() {}

    public CategoriaDoModeloDTO(Integer id,
                                String nome,
                                String descricao,
                                Double valor) {

        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
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

    public Double getValor() {
        return valor;
    }
}
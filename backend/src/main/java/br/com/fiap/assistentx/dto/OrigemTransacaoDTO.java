package br.com.fiap.assistentx.dto;

public class OrigemTransacaoDTO {

    private Integer id;
    private String nome;
    private String tipo;

    public OrigemTransacaoDTO(Integer id, String nome, String tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }
}
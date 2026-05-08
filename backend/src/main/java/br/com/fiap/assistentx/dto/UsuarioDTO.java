package br.com.fiap.assistentx.dto;

public class UsuarioDTO {

    private Integer id;
    private String email;
    private String nome;
    private Integer modeloId;
    private String modeloNome;

    public UsuarioDTO(
            Integer id,
            String email,
            String nome,
            Integer modeloId,
            String modeloNome
    ) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.modeloId = modeloId;
        this.modeloNome = modeloNome;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public Integer getModeloId() {
        return modeloId;
    }

    public String getModeloNome() {
        return modeloNome;
    }
}
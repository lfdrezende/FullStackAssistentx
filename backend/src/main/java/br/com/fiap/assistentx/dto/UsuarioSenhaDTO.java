package br.com.fiap.assistentx.dto;

public class UsuarioSenhaDTO {

    private Integer id;
    private String usuario;
    private String senha;
    private String token;

    public Integer getId() {
        return id;
    }

    public void setId(Integer usuarioId) {
        this.id = usuarioId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
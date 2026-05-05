package br.com.assistentx.fintech.model;

public class TipoInvestimento {
    private int id;
    private String nome;
    private String classificacao;
    private String valorizacao;

    public TipoInvestimento(int id, String nome, String classificacao, String pagamento, String valorizacao) {
        this.id = id;
        this.nome = nome;
        this.classificacao = classificacao;
        this.valorizacao = valorizacao;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return classificacao;
    }

    public String getValorizacao() {
        return valorizacao;
    }
}

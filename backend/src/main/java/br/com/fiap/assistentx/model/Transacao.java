package br.com.assistentx.fintech.model;

import java.time.OffsetDateTime;

public class Transacao extends EntidadeFinanceira {

    private OrigemTransacao origemTransacao;
    private String tipo;

    public Transacao(Usuario usuario, double valor, OffsetDateTime dataHora, int id) {
        this(usuario, valor, null, dataHora, null, id);
    }

    public Transacao(Usuario usuario, double valor, OrigemTransacao origemTransacao, OffsetDateTime dataHora, String tipo) {
        this(usuario, valor, origemTransacao, dataHora, tipo, 0);
    }

    public Transacao(Usuario usuario, double valor, OrigemTransacao origemTransacao, OffsetDateTime dataHora, String tipo, int id) {
        super(usuario, valor, dataHora, id);
        this.origemTransacao = origemTransacao;
        this.tipo = tipo;
    }

    /*public Transacao classificar() {
        if (valor > 0){
            this.tipo = "E";
        } else {
            this.tipo = "S";
        }
        return this;
    }*/

    public double getValor(){
        return valor;
    }

    String getTipo (){
        return tipo;
    }

    public OrigemTransacao getOrigem() {
        return origemTransacao;
    }



    public String exibir() {
        return "Valor: " + valor +
                ", Origem: " + origemTransacao.getNome() +
                ", Data e Hora: " + dataHora +
                ", ID: " + id;
    }

}

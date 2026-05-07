package br.com.fiap.assistentx.model;

public class Saidas extends Transacoes {

    @Override
    public String getTipo() {
        return "S";
    }

    @Override
    public String getDescricao() {
        return "Saídas";
    }


}
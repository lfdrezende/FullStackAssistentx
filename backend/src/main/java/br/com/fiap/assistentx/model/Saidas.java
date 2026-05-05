package br.com.assistentx.fintech.model;

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
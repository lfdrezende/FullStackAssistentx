package br.com.fiap.assistentx.temp;

public class Entradas extends Transacoes {

    @Override
    public String getTipo() {
        return "E";
    }

    @Override
    public String getDescricao() {
        return "Entradas";
    }
}

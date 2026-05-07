package br.com.fiap.assistentx.model;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "t_ax_transacao")
@AttributeOverrides({
        @AttributeOverride(name = "valor", column = @Column(name = "vl_transacao")),
        @AttributeOverride(name = "dataHora", column = @Column(name = "dt_transacao")),
})
public class Transacao extends EntidadeFinanceira {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_transacao")
    @SequenceGenerator(
            name = "seq_transacao",
            sequenceName = "sequencia_transacao",
            allocationSize = 1
    )
    @Column(name = "id_transacao")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_origem")
    private OrigemTransacao origemTransacao;

    @Transient
    private String tipo;

    public Transacao() {}

    public Transacao(
            Usuario usuario,
            double valor,
            OrigemTransacao origemTransacao,
            OffsetDateTime dataHora
    ) {
        this(usuario, valor, origemTransacao, dataHora, null);
    }

    public Transacao(
            Usuario usuario,
            double valor,
            OrigemTransacao origemTransacao,
            OffsetDateTime dataHora,
            Integer id
    ) {
        super(usuario, valor, dataHora);
        this.origemTransacao = origemTransacao;
        this.id = id;
    }

    public OrigemTransacao getOrigemTransacao() {
        return origemTransacao;
    }

    public String getTipo() {
        return valor > 0 ? "E" : "S";
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return valor > 0 ? "Entrada" : "Saída";
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrigemTransacao(OrigemTransacao origemTransacao) {
        this.origemTransacao = origemTransacao;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

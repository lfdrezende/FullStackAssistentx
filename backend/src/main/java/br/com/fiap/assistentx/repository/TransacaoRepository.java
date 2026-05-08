package br.com.fiap.assistentx.repository;

import br.com.fiap.assistentx.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

    List<Transacao> findByValorGreaterThan(double valor);

    List<Transacao> findByValorLessThan(double valor);

    List<Transacao> findByUsuarioId(Integer usuarioId);

    Optional<Transacao> findByIdAndUsuarioId(
            Integer transacaoId,
            Integer usuarioId
    );

    List<Transacao> findByUsuarioIdAndValorGreaterThan(
            Integer usuarioId,
            double valor
    );

    List<Transacao> findByUsuarioIdAndValorLessThan(
            Integer usuarioId,
            double valor
    );
}
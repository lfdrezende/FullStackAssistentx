package br.com.fiap.assistentx.repository;

import br.com.fiap.assistentx.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

    List<Transacao> findByValorGreaterThan(double valor);

    List<Transacao> findByValorLessThan(double valor);

}

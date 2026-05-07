package br.com.fiap.assistentx.repository;

import br.com.fiap.assistentx.model.OrigemTransacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrigemTransacaoRepository extends JpaRepository<OrigemTransacao, Integer> {
}

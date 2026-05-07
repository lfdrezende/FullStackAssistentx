package br.com.fiap.assistentx.repository;

import br.com.fiap.assistentx.model.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestimentoRepository extends JpaRepository<Investimento, Integer> {
}

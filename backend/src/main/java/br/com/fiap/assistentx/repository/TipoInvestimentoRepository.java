package br.com.fiap.assistentx.repository;

import br.com.fiap.assistentx.model.TipoInvestimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoInvestimentoRepository extends JpaRepository<TipoInvestimento, Integer> {
}

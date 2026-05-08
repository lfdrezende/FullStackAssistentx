package br.com.fiap.assistentx.repository;

import br.com.fiap.assistentx.model.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvestimentoRepository extends JpaRepository<Investimento, Integer> {
    List<Investimento> findByUsuarioId(Integer usuarioId);

    Optional<Investimento> findByIdAndUsuarioId(
            Integer investimentoId,
            Integer usuarioId
    );
}

package br.com.fiap.assistentx.service;

import org.springframework.data.jpa.repository.JpaRepository;

public class HelperService {
    private HelperService() {}

    protected static <T> T buscar(
            JpaRepository<T, Integer> repository,
            Integer id,
            String nomeEntidade){

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(nomeEntidade + " não encontrado!"));
    }
}

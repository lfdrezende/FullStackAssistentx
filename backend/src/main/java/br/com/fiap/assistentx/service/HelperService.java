package br.com.fiap.assistentx.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public class HelperService {
    private HelperService() {}

    protected static <T> T buscar(
            JpaRepository<T, Integer> repository,
            Integer id,
            String nomeEntidade){

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(nomeEntidade + " não encontrado!"));
    }

    protected static <T> T buscarDoUsuario(
            Optional<T> optional,
            String nomeEntidade
    ) {

        return optional.orElseThrow(() ->
                new RuntimeException(
                        nomeEntidade + " não encontrado!"
                ));
    }
}

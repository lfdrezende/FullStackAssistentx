package br.com.fiap.assistentx.service;

import br.com.fiap.assistentx.model.OrigemTransacao;
import br.com.fiap.assistentx.repository.OrigemTransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrigemTransacaoService {

    @Autowired
    private OrigemTransacaoRepository origemTransacaoRepository;

    public List<OrigemTransacao> listar(){
        return origemTransacaoRepository.findAll();
    }
}
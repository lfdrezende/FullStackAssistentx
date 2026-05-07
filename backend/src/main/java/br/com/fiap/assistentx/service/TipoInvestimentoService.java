package br.com.fiap.assistentx.service;


import br.com.fiap.assistentx.model.TipoInvestimento;
import br.com.fiap.assistentx.repository.TipoInvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoInvestimentoService {

    @Autowired
    private TipoInvestimentoRepository tipoInvestimentoRepository;

    public List<TipoInvestimento> listar(){
        return tipoInvestimentoRepository.findAll();
    }
}
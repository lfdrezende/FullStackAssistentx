package br.com.fiap.assistentx.controller;


import br.com.fiap.assistentx.model.TipoInvestimento;
import br.com.fiap.assistentx.service.TipoInvestimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TipoInvestimentoController {

    @Autowired
    private TipoInvestimentoService tipoInvestimentoService;

    @GetMapping("/investimento/tipos")
    @ResponseStatus(HttpStatus.OK)
    public List<TipoInvestimento> listar() {
        return tipoInvestimentoService.listar();
    }
}

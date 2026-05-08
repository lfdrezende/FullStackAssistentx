package br.com.fiap.assistentx.controller;


import br.com.fiap.assistentx.dto.OrigemTransacaoDTO;
import br.com.fiap.assistentx.service.OrigemTransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrigemTransacaoController {

    @Autowired
    private OrigemTransacaoService origemTransacaoService;

    @GetMapping("/transacoes/origens")
    @ResponseStatus(HttpStatus.OK)
    public List<OrigemTransacaoDTO> listar() {
        return origemTransacaoService.listar();
    }
}

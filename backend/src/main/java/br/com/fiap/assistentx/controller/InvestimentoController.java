package br.com.fiap.assistentx.controller;

import br.com.fiap.assistentx.dto.InvestimentoDTO;
import br.com.fiap.assistentx.model.Investimento;
import br.com.fiap.assistentx.service.InvestimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InvestimentoController {

    @Autowired
    private InvestimentoService investimentoService;

    @PostMapping("/patrimonio")
    @ResponseStatus(HttpStatus.CREATED)
    public InvestimentoDTO salvar(@RequestBody InvestimentoDTO investimentoDTO) {
        return investimentoService.salvar(investimentoDTO);
    }

    @GetMapping("/patrimonio")
    @ResponseStatus(HttpStatus.OK)
    public List<InvestimentoDTO> listar() {
        return investimentoService.listar();
    }

    @GetMapping("/patrimonio/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InvestimentoDTO buscarPorId(@PathVariable Integer id) {
        return investimentoService.buscarPorId(id);
    }

    @DeleteMapping("/patrimonio/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Integer id) {
        investimentoService.excluir(id);
    }

    @PutMapping("/patrimonio/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InvestimentoDTO atualizar(@RequestBody Investimento investimento) {
        return investimentoService.atualizar(investimento);
    }
}

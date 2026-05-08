package br.com.fiap.assistentx.controller;

import br.com.fiap.assistentx.dto.InvestimentoDTO;
import br.com.fiap.assistentx.dto.ResumoPatrimonioDTO;
import br.com.fiap.assistentx.service.InvestimentoService;
import br.com.fiap.assistentx.service.PatrimonioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuario/{usuarioId}/patrimonio")
public class InvestimentoController {

    @Autowired
    private InvestimentoService investimentoService;

    @Autowired
    private PatrimonioService patrimonioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvestimentoDTO salvar(@RequestBody InvestimentoDTO investimentoDTO) {
        return investimentoService.salvar(investimentoDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InvestimentoDTO> listar(
            @PathVariable Integer usuarioId) {

        return investimentoService.listar(usuarioId);
    }

    @GetMapping("/{investimentoId}")
    @ResponseStatus(HttpStatus.OK)
    public InvestimentoDTO buscarPorId(@PathVariable Integer usuarioId, @PathVariable Integer investimentoId) {
        return investimentoService.buscarPorId(usuarioId, investimentoId);
    }

    @DeleteMapping("/{investimentoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Integer usuarioId, @PathVariable Integer investimentoId) {
        investimentoService.excluir(usuarioId, investimentoId);
    }

    @PutMapping("/{investimentoId}")
    @ResponseStatus(HttpStatus.OK)
    public InvestimentoDTO atualizar(@RequestBody InvestimentoDTO investimentoDTO) {
        return investimentoService.atualizar(investimentoDTO);
    }

    @GetMapping("/resumo")
    @ResponseStatus(HttpStatus.OK)
    public ResumoPatrimonioDTO obterResumo(@PathVariable Integer usuarioId) {
        return patrimonioService.obterResumo(usuarioId);
    }
}

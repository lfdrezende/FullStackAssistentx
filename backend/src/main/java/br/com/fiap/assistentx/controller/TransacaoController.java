package br.com.fiap.assistentx.controller;

import br.com.fiap.assistentx.dto.ResumoEntradasDTO;
import br.com.fiap.assistentx.dto.ResumoSaidasDTO;
import br.com.fiap.assistentx.dto.TransacaoDTO;
import br.com.fiap.assistentx.service.TransacaoService;
import br.com.fiap.assistentx.service.TransacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuario/{usuarioId}")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private TransacoesService transacoesService;

    //Entradas
    @PostMapping("/entradas")
    @ResponseStatus(HttpStatus.CREATED)
    public TransacaoDTO salvarEntrada(@RequestBody TransacaoDTO transacaoDTO){
        return transacaoService.salvar(transacaoDTO, "E");
    }

    @GetMapping("/entradas")
    @ResponseStatus(HttpStatus.OK)
    public List<TransacaoDTO> listarEntradas(@PathVariable Integer usuarioId) {
        return transacaoService.listar(usuarioId,"E");
    }

    @GetMapping("/entradas/{transacaoId}")
    @ResponseStatus(HttpStatus.OK)
    public TransacaoDTO buscarEntradaPorId(@PathVariable Integer usuarioId, @PathVariable Integer transacaoId){
        return transacaoService.buscarPorId(usuarioId,transacaoId,"E");
    }

    @DeleteMapping("/entradas/{transacaoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirEntrada(@PathVariable Integer usuarioId, @PathVariable Integer transacaoId){
        transacaoService.excluir(usuarioId, transacaoId,"E");
    }

    @PutMapping("/entradas/{transacaoId}")
    @ResponseStatus(HttpStatus.OK)
    public TransacaoDTO atualizarEntrada(@RequestBody TransacaoDTO transacaoDTO){
        return transacaoService.atualizar(transacaoDTO, "E");
    }

    @GetMapping("/entradas/resumo")
    @ResponseStatus(HttpStatus.OK)
    public ResumoEntradasDTO resumoEntradas(@PathVariable Integer usuarioId) {
        return transacoesService.obterResumoEntradas(usuarioId);
    }

    //Saidas
    @PostMapping("/saidas")
    @ResponseStatus(HttpStatus.CREATED)
    public TransacaoDTO salvarSaida(@RequestBody TransacaoDTO transacaoDTO){
        return transacaoService.salvar(transacaoDTO, "S");
    }

    @GetMapping("/saidas")
    @ResponseStatus(HttpStatus.OK)
    public List<TransacaoDTO> listarSaidas(@PathVariable Integer usuarioId) {
        return transacaoService.listar(usuarioId,"S");
    }

    @GetMapping("/saidas/{transacaoId}")
    @ResponseStatus(HttpStatus.OK)
    public TransacaoDTO buscarSaidaPorId(@PathVariable Integer usuarioId, @PathVariable Integer transacaoId){
        return transacaoService.buscarPorId(usuarioId, transacaoId,"S");
    }

    @DeleteMapping("/saidas/{transacaoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirSaida(@PathVariable Integer usuarioId, @PathVariable Integer transacaoId){
        transacaoService.excluir(usuarioId, transacaoId,"S");
    }

    @PutMapping("/saidas/{transacaoId}")
    @ResponseStatus(HttpStatus.OK)
    public TransacaoDTO atualizarSaida(@RequestBody TransacaoDTO transacaoDTO){
        return transacaoService.atualizar(transacaoDTO, "S");
    }

    @GetMapping("/saidas/resumo")
    @ResponseStatus(HttpStatus.OK)
    public ResumoSaidasDTO resumoSaidas(@PathVariable Integer usuarioId) {
        return transacoesService.obterResumoSaidas(usuarioId);
    }

}
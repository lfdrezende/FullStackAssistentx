package br.com.fiap.assistentx.controller;

import br.com.fiap.assistentx.dto.TransacaoDTO;
import br.com.fiap.assistentx.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    //Entradas
    @PostMapping("/entradas")
    @ResponseStatus(HttpStatus.CREATED)
    public TransacaoDTO salvarEntrada(@RequestBody TransacaoDTO transacaoDTO){
        return transacaoService.salvar(transacaoDTO, "E");
    }

    @GetMapping("/entradas")
    @ResponseStatus(HttpStatus.OK)
    public List<TransacaoDTO> listarEntradas() {
        return transacaoService.listar("E");
    }

    @GetMapping("/entradas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransacaoDTO buscarEntradaPorId(@PathVariable Integer id){
        return transacaoService.buscarPorId(id,"E");
    }

    @DeleteMapping("/entradas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirEntrada(@PathVariable Integer id){
        transacaoService.excluir(id,"E");
    }

    @PutMapping("/entradas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransacaoDTO atualizarEntrada(@RequestBody TransacaoDTO transacaoDTO){
        return transacaoService.atualizar(transacaoDTO, "E");
    }

    //Saidas
    @PostMapping("/saidas")
    @ResponseStatus(HttpStatus.CREATED)
    public TransacaoDTO salvarSaida(@RequestBody TransacaoDTO transacaoDTO){
        return transacaoService.salvar(transacaoDTO, "S");
    }

    @GetMapping("/saidas")
    @ResponseStatus(HttpStatus.OK)
    public List<TransacaoDTO> listarSaidas() {
        return transacaoService.listar("S");
    }

    @GetMapping("/saidas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransacaoDTO buscarSaidaPorId(@PathVariable Integer id){
        return transacaoService.buscarPorId(id,"S");
    }

    @DeleteMapping("/saidas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirSaida(@PathVariable Integer id){
        transacaoService.excluir(id,"S");
    }

    @PutMapping("/saidas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransacaoDTO atualizarSaida(@RequestBody TransacaoDTO transacaoDTO){
        return transacaoService.atualizar(transacaoDTO, "S");
    }

}
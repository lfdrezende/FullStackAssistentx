package br.com.fiap.assistentx.controller;

import br.com.fiap.assistentx.dto.ResumoModeloDTO;
import br.com.fiap.assistentx.dto.UsuarioDTO;
import br.com.fiap.assistentx.dto.UsuarioModeloDTO;
import br.com.fiap.assistentx.model.Usuario;
import br.com.fiap.assistentx.service.ResumoModeloService;
import br.com.fiap.assistentx.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario/{usuarioId}")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ResumoModeloService resumoModeloService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDTO buscarPorId(@PathVariable Integer usuarioId) {
        return usuarioService.buscarDTOPorId(usuarioId);
    }

    @PutMapping("/modelo/{modeloId}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDTO atualizarModelo(@RequestBody UsuarioModeloDTO dto){
        return usuarioService.atualizarModelo(dto);
    }

    @GetMapping("/modelo/{modeloId}/resumo")
    @ResponseStatus(HttpStatus.OK)
    public ResumoModeloDTO obterResumo(@PathVariable Integer usuarioId, @PathVariable Integer modeloId) {
        return resumoModeloService.obterResumo(usuarioId,modeloId);
    }
}


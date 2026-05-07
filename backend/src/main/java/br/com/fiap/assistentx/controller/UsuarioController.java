package br.com.fiap.assistentx.controller;

import br.com.fiap.assistentx.dto.UsuarioModeloDTO;
import br.com.fiap.assistentx.model.Usuario;
import br.com.fiap.assistentx.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuario/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario buscarPorId(@PathVariable Integer id) {
        return usuarioService.buscarPorId(id);
    }

    @PutMapping("/usuario/modelo")
    @ResponseStatus(HttpStatus.OK)
    public Usuario atualizarModelo(@RequestBody UsuarioModeloDTO dto){
        return usuarioService.atualizarModelo(dto);
    }
}

package br.com.fiap.assistentx.controller;

import br.com.fiap.assistentx.dto.ModeloDTO;
import br.com.fiap.assistentx.dto.ResumoModeloDTO;
import br.com.fiap.assistentx.service.ModeloService;
import br.com.fiap.assistentx.service.ResumoModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/modelo")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @Autowired
    private ResumoModeloService resumoModeloService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ModeloDTO> listar() {
        return modeloService.listar();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ModeloDTO listar(@PathVariable Integer id) {
        return modeloService.buscarPorId(id);
    }

}

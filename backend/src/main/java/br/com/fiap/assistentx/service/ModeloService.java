package br.com.fiap.assistentx.service;

import br.com.fiap.assistentx.dto.CategoriaDoModeloDTO;
import br.com.fiap.assistentx.dto.ModeloDTO;
import br.com.fiap.assistentx.model.Modelo;
import br.com.fiap.assistentx.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.fiap.assistentx.service.HelperService.buscar;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    public List<ModeloDTO> listar() {

        return modeloRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public ModeloDTO buscarPorId(Integer id) {

        Modelo modelo = buscar(modeloRepository, id, "Modelo");

        return toDTO(modelo);
    }

    private ModeloDTO toDTO(Modelo modelo) {

        List<CategoriaDoModeloDTO> categorias = modelo
                .getCategorias()
                .stream()
                .map(mc -> new CategoriaDoModeloDTO(
                        mc.getCategoria().getId(),
                        mc.getCategoria().getNome(),
                        mc.getCategoria().getDescricao(),
                        mc.getValor()
                ))
                .toList();

        return new ModeloDTO(
                modelo.getId(),
                modelo.getNome(),
                modelo.getDescricao(),
                categorias
        );
    }
}

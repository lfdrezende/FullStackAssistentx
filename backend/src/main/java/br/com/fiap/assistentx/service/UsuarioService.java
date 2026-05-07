package br.com.fiap.assistentx.service;

import br.com.fiap.assistentx.dto.UsuarioModeloDTO;
import br.com.fiap.assistentx.model.Usuario;
import br.com.fiap.assistentx.repository.ModeloRepository;
import br.com.fiap.assistentx.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModeloRepository modeloRepository;

    public Usuario buscarPorId(Integer id){
        return HelperService.buscar(usuarioRepository,id,"Usuário");
    }

    public Usuario atualizarModelo(UsuarioModeloDTO dto){
        Usuario usuario = HelperService.buscar(usuarioRepository,
                dto.getUsuarioId(),
                "Usuário");

        usuario.setModelo(HelperService.buscar(modeloRepository,
                dto.getModeloId(),
                "Modelo"));

        return usuarioRepository.save(usuario);
    }
}
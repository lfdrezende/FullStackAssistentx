package br.com.fiap.assistentx.service;

import br.com.fiap.assistentx.dto.UsuarioDTO;
import br.com.fiap.assistentx.dto.UsuarioModeloDTO;
import br.com.fiap.assistentx.dto.UsuarioSenhaDTO;
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

    public UsuarioDTO buscarDTOPorId(Integer id){

        Usuario usuario = HelperService.buscar(
                usuarioRepository,
                id,
                "Usuário"
        );

        return toDTO(usuario);
    }

    public UsuarioDTO atualizarModelo(UsuarioModeloDTO dto){
        Usuario usuario = HelperService.buscar(usuarioRepository,
                dto.getUsuarioId(),
                "Usuário");

        usuario.setModelo(HelperService.buscar(modeloRepository,
                dto.getModeloId(),
                "Modelo"));

        return toDTO(usuarioRepository.save(usuario));
    }

    private UsuarioDTO toDTO(Usuario usuario){

        return new UsuarioDTO(
                usuario.getId(),
                usuario.getEmail(),
                usuario.getNome(),
                usuario.getModelo().getId(),
                usuario.getModelo().getNome()
        );
    }

    public UsuarioSenhaDTO login(UsuarioSenhaDTO dto) {

        Usuario usuario = usuarioRepository.findByEmail(dto.getUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!usuario.getSenha().equals(dto.getSenha())) {
            throw new RuntimeException("Senha incorreta");
        }
        dto.setId(usuario.getId());
        dto.setToken("Bearer usuario_" + usuario.getId());
        return dto;
    }

    public Usuario buscarPorId(Integer id){
        return HelperService.buscar(usuarioRepository,id,"Usuário");
    }
}
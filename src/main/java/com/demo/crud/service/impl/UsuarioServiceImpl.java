package com.demo.crud.service.impl;

import com.demo.crud.model.Usuario;
import com.demo.crud.repository.UsuarioRepository;
import com.demo.crud.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario guardar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario actualizar(Long id, Usuario usuario) {

        Usuario usuarioActualizado = obtenerPorId(id);
        if (usuarioActualizado != null) {
            usuarioActualizado.setNombre(usuario.getNombre());
            usuarioActualizado.setEmail(usuario.getEmail());
        }
        return usuarioRepository.save(usuarioActualizado);
    }

    @Override
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
}

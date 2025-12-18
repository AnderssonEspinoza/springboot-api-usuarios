package com.demo.crud.service;

import com.demo.crud.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario guardar (Usuario usuario);
    List<Usuario> listar();
    Usuario obtenerPorId(Long id);
    Usuario actualizar(Long id, Usuario usuario);
    void eliminar(Long id);
}

package com.demo.crud.controller;


import com.demo.crud.model.Usuario;
import com.demo.crud.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario crear(@Valid @RequestBody Usuario usuario) {
        return usuarioService.guardar(usuario);
    }

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listar();
    }

    @GetMapping("/{id}")
    public Usuario obtener(@PathVariable Long id) {
        return usuarioService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Usuario actualizar(
            @PathVariable Long id,
            @Valid @RequestBody Usuario usuario
    ) {
        return usuarioService.actualizar(id, usuario);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return "Usuario eliminado correctamente";
    }
}

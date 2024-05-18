package com.nassau.Biblioteca.controllers;

import com.nassau.Biblioteca.models.UsuarioModel;
import com.nassau.Biblioteca.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping()
    public List<UsuarioModel> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid UsuarioModel usuario){
        usuarioRepository.save(usuario);
    }
}

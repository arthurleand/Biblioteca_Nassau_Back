package com.nassau.Biblioteca.controllers;

import com.nassau.Biblioteca.models.UsuarioModel;
import com.nassau.Biblioteca.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping()
    public ResponseEntity<List<UsuarioModel>> listarUsuarios(){
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UsuarioModel> cadastrar(@RequestBody @Valid UsuarioModel usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
    }
}

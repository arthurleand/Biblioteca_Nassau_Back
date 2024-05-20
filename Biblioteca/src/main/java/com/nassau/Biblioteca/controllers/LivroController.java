package com.nassau.Biblioteca.controllers;

import com.nassau.Biblioteca.models.LivroModel;
import com.nassau.Biblioteca.repositories.LivroRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public ResponseEntity<List<LivroModel>> listar(){
        return ResponseEntity.ok(livroRepository.findAll());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<LivroModel> cadastrar(@RequestBody @Valid LivroModel livroModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(livroRepository.save(livroModel));
    }
}

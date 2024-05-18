package com.nassau.Biblioteca.controllers;

import com.nassau.Biblioteca.models.LivroModel;
import com.nassau.Biblioteca.repositories.LivroRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public List<LivroModel> listar(){
        return livroRepository.findAll();
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid LivroModel livroModel){
        livroRepository.save(livroModel);
    }
}

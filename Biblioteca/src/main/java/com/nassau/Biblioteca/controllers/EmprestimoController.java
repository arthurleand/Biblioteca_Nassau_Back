package com.nassau.Biblioteca.controllers;

import com.nassau.Biblioteca.models.EmprestimoModel;
import com.nassau.Biblioteca.repositories.EmprestimoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @GetMapping
    public ResponseEntity<List<EmprestimoModel>> listar(){
        return ResponseEntity.ok(emprestimoRepository.findAll());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EmprestimoModel> cadastrar(@RequestBody @Valid EmprestimoModel emprestimoModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(emprestimoRepository.save(emprestimoModel));
    }
}

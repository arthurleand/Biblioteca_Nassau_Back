package com.nassau.Biblioteca.controllers;

import com.nassau.Biblioteca.models.EmprestimoModel;
import com.nassau.Biblioteca.repositories.EmprestimoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @GetMapping
    public List<EmprestimoModel> listar(){
        return emprestimoRepository.findAll();
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid EmprestimoModel emprestimoModel){
        emprestimoRepository.save(emprestimoModel);
    }
}

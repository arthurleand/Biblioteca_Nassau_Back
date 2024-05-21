package com.nassau.Biblioteca.services;

import com.nassau.Biblioteca.models.EmprestimoModel;
import com.nassau.Biblioteca.repositories.EmprestimoRepository;
import com.nassau.Biblioteca.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity<EmprestimoModel> cadastrar(EmprestimoModel emprestimoModel) {

        var statistics = verificaQuantidadeEmprestimo(emprestimoModel);

        if (statistics.size()>=3){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já tem mais de 3 livros emprestados!!");
        }else {
            return ResponseEntity.status(201).body(emprestimoRepository.save(emprestimoModel));
        }
    }

    public List<EmprestimoModel> verificaQuantidadeEmprestimo(EmprestimoModel emprestimoModel){
        var usuario = usuarioRepository.findById(emprestimoModel.getFkUsuario().getId());

        var statistics = emprestimoRepository.findAll().stream()
                .filter(e -> e.getFkUsuario().getId().equals(usuario.get().getId()))
                .filter(e -> e.getEntregue().equals(false))
                .collect(Collectors.toList());
        return statistics;
    }
}

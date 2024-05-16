package com.nassau.Biblioteca.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_emprestimo")
public class EmprestimoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataEmprestimo = LocalDate.now();
    private LocalDate dateEntrega;

    private Boolean entregue = false;

    @NotNull
    @OneToOne
    private LivroModel fkLivro;

    @NotNull
    @OneToOne()
    private UsuarioModel fkUsuario;

    public EmprestimoModel(LocalDate dateEntrega, LivroModel fkLivro, UsuarioModel fkUsuario, Long id) {
        this.dateEntrega = dateEntrega;
        this.fkLivro = fkLivro;
        this.fkUsuario = fkUsuario;
        this.id = id;
    }
}

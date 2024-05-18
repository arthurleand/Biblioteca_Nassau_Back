package com.nassau.Biblioteca.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_livro")
public class LivroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    private String foto;

    @OneToOne(mappedBy = "fkLivro", cascade = CascadeType.REMOVE)
    private EmprestimoModel emprestimoModel;

    public LivroModel(String descricao, EmprestimoModel emprestimoModel, String foto, String nome) {
        this.descricao = descricao;
        this.emprestimoModel = emprestimoModel;
        this.nome = nome;
        if (foto == null){
            this.foto = "https://imgur.com/a/ZSudKdo";
        }else{
            this.foto = foto;
        }
    }
}

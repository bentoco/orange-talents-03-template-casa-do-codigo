package br.com.zupacademy.gabriel.casadocodigo.livro;

import java.util.List;
import java.util.stream.Collectors;

public class LivroResponseIdNome {
    private Long id;
    private String titulo;


    public LivroResponseIdNome (Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId () {
        return id;
    }

    public String getTitulo () {
        return titulo;
    }

    public static List<LivroResponseIdNome> toDto ( List<Livro> livros ) {
        return livros.stream().map(LivroResponseIdNome::new).collect(Collectors.toList());
    }
}

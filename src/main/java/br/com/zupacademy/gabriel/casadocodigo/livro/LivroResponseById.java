package br.com.zupacademy.gabriel.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class LivroResponseById {
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroPaginas;
    private String isbn;
    private String dataPublicacao;
    private String nomeCategoria;
    private String nomeAutor;
    private String descricaoAutor;

    public LivroResponseById ( Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();
        this.nomeCategoria = livro.getAutor().getNome();
        this.nomeAutor = livro.getCategoria().getNomeCategoria();
        this.descricaoAutor = livro.getAutor().getDescricao();
        this.dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getTitulo () {
        return titulo;
    }

    public String getResumo () {
        return resumo;
    }

    public String getSumario () {
        return sumario;
    }

    public BigDecimal getPreco () {
        return preco;
    }

    public Integer getNumeroPaginas () {
        return numeroPaginas;
    }

    public String getIsbn () {
        return isbn;
    }

    public String getDataPublicacao () {
        return dataPublicacao;
    }

    public String getNomeCategoria () {
        return nomeCategoria;
    }

    public String getNomeAutor () {
        return nomeAutor;
    }

    public String getDescricaoAutor () {
        return descricaoAutor;
    }
}

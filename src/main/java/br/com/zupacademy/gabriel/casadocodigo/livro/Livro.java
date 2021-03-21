package br.com.zupacademy.gabriel.casadocodigo.livro;

import br.com.zupacademy.gabriel.casadocodigo.autor.Autor;
import br.com.zupacademy.gabriel.casadocodigo.categoria.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @Column(nullable = false, unique = true)
    private String titulo;
    @NotNull @Size ( max = 500) @Column(nullable = false, columnDefinition = "TEXT")
    private String resumo;
    @Column(columnDefinition = "TEXT")
    private String sumario;
    @NotNull @Min (20) @Column(nullable = false)
    private BigDecimal preco;
    @NotNull @Min (100) @Column(nullable = false)
    private Integer numeroPaginas;
    @NotNull @Column(nullable = false, unique = true)
    private String isbn;
    @Future @JsonFormat (pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING) @Column(nullable = false)
    private LocalDate dataPublicacao;
    @ManyToOne @JoinColumn(name = "categoria_id", foreignKey = @ForeignKey(name ="CATEGORIA_ID_FK"))
    private Categoria categoria;
    @ManyToOne @JoinColumn(name = "autor_id", foreignKey = @ForeignKey(name ="AUTOR_ID_FK"))
    private Autor autor;

    public Livro (
            @NotNull String titulo ,
            @NotNull @Size ( max = 500 ) String resumo ,
            String sumario ,
            @NotNull @Min ( 20 ) BigDecimal preco ,
            @NotNull @Min ( 100 ) Integer numeroPaginas ,
            @NotNull String isbn ,
            @Future LocalDate dataPublicacao ,
            Categoria categoria ,
            Autor autor ) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    @Override public String toString () {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", numPaginas=" + numeroPaginas +
                ", isbn=" + isbn +
                ", dataPublicacao=" + dataPublicacao +
                ", categoria=" + categoria +
                ", autor=" + autor +
                '}';
    }
}

package br.com.zupacademy.gabriel.casadocodigo.livro;

import br.com.zupacademy.gabriel.casadocodigo.autor.Autor;
import br.com.zupacademy.gabriel.casadocodigo.categoria.Categoria;
import br.com.zupacademy.gabriel.casadocodigo.config.validation.ExistId;
import br.com.zupacademy.gabriel.casadocodigo.config.validation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {
    @NotNull @UniqueValue( fieldName = "titulo", domainClass = Livro.class )
    private String titulo;
    @NotNull @Size( max = 500)
    private String resumo;
    private String sumario;
    @NotNull @Min (20)
    private BigDecimal preco;
    @NotNull @Min (100)
    private Integer numeroPaginas;
    @NotNull @UniqueValue(fieldName = "isbn", domainClass = Livro.class)
    private String isbn;
    @NotNull @Future @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;
    @NotNull @ExistId( fieldName = "id", domainClass = Categoria.class )
    private Long idCategoria;
    @NotNull @ExistId ( fieldName = "id", domainClass = Autor.class )
    private Long idAutor;

    public LivroRequest (
            @NotNull String titulo ,
            @NotNull @Size ( max = 500 ) String resumo ,
            String sumario ,
            @NotNull @Min ( 20 ) BigDecimal preco ,
            @NotNull @Min ( 100 ) Integer numeroPaginas ,
            @NotNull String isbn ,
            @NotNull Long idCategoria ,
            @NotNull Long idAutor ) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    /*
    * jackson encontrou um problema ao desserializar
    * o json com a data no parâmetro pelo constructor,
    * por esse motivo foi necessário criar setter abaixo
    * @param dataPublicacao
    * */
    public void setDataPublicacao ( LocalDate dataPublicacao ) {
        this.dataPublicacao = dataPublicacao;
    }

    public Livro toModel ( EntityManager manager ) {
        @NotNull Categoria categoria = manager.find(Categoria.class, idCategoria);
        @NotNull Autor autor = manager.find(Autor.class, idAutor);
        Assert.state(categoria != null, "ID da categoria informado não existe em nosso banco de dados " + idCategoria);
        Assert.state(autor != null, "ID do autor(a) informado não existe em nosso banco de dados " + idAutor);

        return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, categoria, autor);
    }
}

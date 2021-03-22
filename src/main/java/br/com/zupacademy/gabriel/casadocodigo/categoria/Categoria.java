package br.com.zupacademy.gabriel.casadocodigo.categoria;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Column(nullable = false)
    private String nomeCategoria;

    public Categoria ( @NotBlank String nomeCategoria ) {
        this.nomeCategoria = nomeCategoria;
    }

    @Deprecated
    public Categoria () {
    }

    public String getNomeCategoria () {
        return nomeCategoria;
    }

    @Override public String toString () {
        return "Categoria{" +
                "id=" + id +
                ", nomeCategoria='" + nomeCategoria + '\'' +
                '}';
    }
}

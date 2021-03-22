package br.com.zupacademy.gabriel.casadocodigo.estado;

import br.com.zupacademy.gabriel.casadocodigo.pais.Pais;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Column(nullable = false)
    private String nome;
    @ManyToOne
    private @NotNull @Valid Pais pais;

    public Estado (
            @NotBlank String nome ,
            @NotNull @Valid Pais pais ) {
        this.nome = nome;
        this.pais = pais;
    }

    public Estado () {
    }

    public Long getId () {
        return id;
    }

    @Override public String toString () {
        return "Estado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", pais=" + pais +
                '}';
    }
}

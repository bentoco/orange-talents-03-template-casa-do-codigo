package br.com.zupacademy.gabriel.casadocodigo.pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Column(nullable = false)
    private String nome;

    public Pais ( @NotBlank String nome ) {
        this.nome = nome;
    }

    public Pais () {
    }

    public Long getId () {
        return id;
    }

    public String getNome () {
        return nome;
    }

    @Override public String toString () {
        return "Pais{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}

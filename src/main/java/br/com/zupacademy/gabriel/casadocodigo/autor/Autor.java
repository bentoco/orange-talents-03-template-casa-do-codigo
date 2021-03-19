package br.com.zupacademy.gabriel.casadocodigo.autor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Column(nullable = false)
    private String nome;
    @NotBlank @Email @Column(nullable = false)
    private String email;
    @NotBlank @Size (max = 400) @Column(nullable = false, length = 400)
    private  String descricao;

    public Autor (
            @NotBlank String nome,
            @NotBlank String email,
            @NotBlank @Size ( max = 400 ) String descricao ) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    @Override public String toString () {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}

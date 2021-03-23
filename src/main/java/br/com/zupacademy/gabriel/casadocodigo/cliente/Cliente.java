package br.com.zupacademy.gabriel.casadocodigo.cliente;

import br.com.zupacademy.gabriel.casadocodigo.estado.Estado;
import br.com.zupacademy.gabriel.casadocodigo.pais.Pais;

import javax.persistence.*;

@Entity
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String sobrenome;
    @Column(nullable = false)
    private TipoPessoa tipoPessoa;
    @Column(nullable = false, unique = true)
    private String documento;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false)
    private String complemento;
    @Column(nullable = false)
    private String cidade;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Pais pais;
    @ManyToOne
    private Estado estado;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false)
    private String cep;

    public Cliente (
            String email ,
            String nome ,
            String sobrenome ,
            TipoPessoa tipoPessoa ,
            String documento ,
            String endereco ,
            String complemento ,
            String cidade ,
            Pais pais , Estado estado , String telefone , String cep ) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tipoPessoa = tipoPessoa;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente () {
    }

    @Override public String toString () {
        return "Cliente{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", tipoPessoa=" + tipoPessoa +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", pais=" + pais +
                ", estado=" + estado +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}

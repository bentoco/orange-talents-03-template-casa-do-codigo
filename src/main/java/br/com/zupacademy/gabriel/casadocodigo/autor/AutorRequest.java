package br.com.zupacademy.gabriel.casadocodigo.autor;

import br.com.zupacademy.gabriel.casadocodigo.config.validation.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequest {
    private @NotBlank String nome;
    @UniqueValue (domainClass = Autor.class, fieldName = "email")
    private @NotBlank @Email String email;
    private @NotBlank @Size(max = 400) String descricao;

    public AutorRequest (
            @NotBlank String nome,
            @NotBlank @Email String email,
            @NotBlank @Size ( max = 400 ) String descricao ) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel(){
        return new Autor(this.nome, this.email,this.descricao);
    }

    public String getEmail () {
        return email;
    }
}

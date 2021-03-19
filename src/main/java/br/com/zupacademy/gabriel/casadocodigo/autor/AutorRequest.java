package br.com.zupacademy.gabriel.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequest {
    private @NotBlank String nome;
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
}

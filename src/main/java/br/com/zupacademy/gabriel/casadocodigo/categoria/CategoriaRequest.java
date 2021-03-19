package br.com.zupacademy.gabriel.casadocodigo.categoria;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    private String nomeCategoria;

    @JsonCreator
    public CategoriaRequest ( @NotBlank @JsonProperty ("nomeCategoria") String nomeCategoria ) {
        this.nomeCategoria = nomeCategoria;
    }

    public Categoria toModel(){
        return new Categoria(this.nomeCategoria);
    }

    public String getNomeCategoria () {
        return nomeCategoria;
    }
}

package br.com.zupacademy.gabriel.casadocodigo.categoria;


import br.com.zupacademy.gabriel.casadocodigo.config.validation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    @UniqueValue (domainClass = Categoria.class, fieldName = "nomeCategoria")
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

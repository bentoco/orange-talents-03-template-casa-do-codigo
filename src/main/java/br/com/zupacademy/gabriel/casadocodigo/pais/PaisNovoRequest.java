package br.com.zupacademy.gabriel.casadocodigo.pais;

import br.com.zupacademy.gabriel.casadocodigo.config.validation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class PaisNovoRequest {

    @NotBlank
    @UniqueValue(fieldName = "nome", domainClass = Pais.class)
    private String nome;

    @JsonCreator
    public PaisNovoRequest ( @NotBlank @JsonProperty ("nome") String nome ) {
        this.nome = nome;
    }

    public Pais toModel () {
        return new Pais(this.nome);
    }
}

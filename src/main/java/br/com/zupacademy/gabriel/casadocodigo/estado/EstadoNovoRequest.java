package br.com.zupacademy.gabriel.casadocodigo.estado;

import br.com.zupacademy.gabriel.casadocodigo.validation.ExistId;
import br.com.zupacademy.gabriel.casadocodigo.validation.UniqueStateInCountry;
import br.com.zupacademy.gabriel.casadocodigo.pais.Pais;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@UniqueStateInCountry( estadoClass = Estado.class )
public class EstadoNovoRequest {

    @NotBlank
    private String nome;
    @NotNull @ExistId(fieldName = "id", domainClass = Pais.class)
    private Long idPais;

    public EstadoNovoRequest ( @NotBlank String nome , @NotNull Long idPais ) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public String getNome () {
        return nome;
    }

    public Long getIdPais () {
        return idPais;
    }

    public Estado toModel (EntityManager maneger ) {
       Pais pais = maneger.find(Pais.class, idPais);
       return new Estado(nome, pais);
    }
}

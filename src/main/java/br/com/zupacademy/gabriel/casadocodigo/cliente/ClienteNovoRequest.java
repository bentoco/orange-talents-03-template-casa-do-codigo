package br.com.zupacademy.gabriel.casadocodigo.cliente;

import br.com.zupacademy.gabriel.casadocodigo.validation.ClienteGroupSequenceProvider;
import br.com.zupacademy.gabriel.casadocodigo.validation.ExistId;
import br.com.zupacademy.gabriel.casadocodigo.validation.PaisEstadoExist;
import br.com.zupacademy.gabriel.casadocodigo.validation.UniqueValue;
import br.com.zupacademy.gabriel.casadocodigo.estado.Estado;
import br.com.zupacademy.gabriel.casadocodigo.pais.Pais;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.persistence.EntityManager;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@GroupSequenceProvider( ClienteGroupSequenceProvider.class)
@PaisEstadoExist (clienteClass = Cliente.class)
public class ClienteNovoRequest {
    @NotBlank @Email
    @UniqueValue(fieldName = "email", domainClass = Cliente.class)
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotNull @Enumerated( EnumType.STRING )
    private TipoPessoa tipoPessoa;
    @CPF(groups = CpfGroup.class) @CNPJ(groups = CnpjGroup.class)
    @UniqueValue(fieldName = "documento", domainClass = Cliente.class)
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull @ExistId(fieldName = "id", domainClass = Pais.class)
    private Long idPais;
    private Long idEstado;
    @NotNull
    private String telefone;
    @NotNull @Size(min = 8, max = 8)
    private String cep;

    public ClienteNovoRequest (
            @NotBlank @Email String email ,
            @NotBlank String nome ,
            @NotBlank String sobrenome ,
            @NotNull TipoPessoa tipoPessoa ,
            @CPF ( groups = CpfGroup.class ) @CNPJ ( groups = CnpjGroup.class ) String documento ,
            @NotBlank String endereco ,
            @NotBlank String complemento ,
            @NotBlank String cidade ,
            @NotNull Long idPais ,
            Long idEstado ,
            @NotNull String telefone ,
            @NotNull @Size ( min = 8, max = 8 ) String cep ) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tipoPessoa = tipoPessoa;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public TipoPessoa getTipoPessoa () {
        return tipoPessoa;
    }

    public Long getIdPais () {
        return idPais;
    }

    public Long getIdEstado () {
        return idEstado;
    }

    @Override public String toString () {
        return "ClienteNovoRequest{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", tipoPessoa=" + tipoPessoa +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", idPais=" + idPais +
                ", idEstado=" + idEstado +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }

    public Cliente toModel ( EntityManager manager ) {
        Pais pais =  manager.find(Pais.class, idPais);
        Estado estado = null;
        if(idEstado != null) {
            estado = manager.find(Estado.class , idEstado);
        }
        return new Cliente(email, nome, sobrenome, tipoPessoa, documento, endereco, complemento, cidade, pais, estado, telefone, cep);
    }
}

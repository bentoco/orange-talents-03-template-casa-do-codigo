package br.com.zupacademy.gabriel.casadocodigo.validation;

import br.com.zupacademy.gabriel.casadocodigo.estado.Estado;
import br.com.zupacademy.gabriel.casadocodigo.estado.EstadoNovoRequest;
import br.com.zupacademy.gabriel.casadocodigo.estado.EstadoRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueStateInCountryValidator implements ConstraintValidator<UniqueStateInCountry, EstadoNovoRequest> {

    private Class<?> estado;

    private final EstadoRepository repository;

    public UniqueStateInCountryValidator (
            EstadoRepository repository ) {
        this.repository = repository;
    }

    @Override public void initialize ( UniqueStateInCountry params ) {
        this.estado = params.estadoClass();
    }

    @Override public boolean isValid ( EstadoNovoRequest value , ConstraintValidatorContext context ) {
        Long idPais = value.getIdPais();
        String nome = value.getNome();

        Optional<Estado> res = repository.findByNomeAndPaisId(nome , idPais);
        return res.isEmpty();
        }
    }


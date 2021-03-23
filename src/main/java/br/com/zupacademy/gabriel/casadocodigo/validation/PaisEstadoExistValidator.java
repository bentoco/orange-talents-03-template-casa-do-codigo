package br.com.zupacademy.gabriel.casadocodigo.validation;

import br.com.zupacademy.gabriel.casadocodigo.cliente.ClienteNovoRequest;
import br.com.zupacademy.gabriel.casadocodigo.estado.Estado;
import br.com.zupacademy.gabriel.casadocodigo.estado.EstadoRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class PaisEstadoExistValidator implements ConstraintValidator<PaisEstadoExist, ClienteNovoRequest> {

    private final EstadoRepository repository;

    public PaisEstadoExistValidator ( EstadoRepository repository ) {
        this.repository = repository;
    }

    private Class<?> clienteClass;

    @Override public void initialize ( PaisEstadoExist params ) {
        clienteClass = params.clienteClass();
    }

    @Override public boolean isValid ( ClienteNovoRequest value , ConstraintValidatorContext context ) {
        Long idPais = value.getIdPais();
        Optional<Estado> paisPossuiEstado = repository.findByPaisId(idPais);
        return paisPossuiEstado.isEmpty() || value.getIdEstado() != null;
    }
}

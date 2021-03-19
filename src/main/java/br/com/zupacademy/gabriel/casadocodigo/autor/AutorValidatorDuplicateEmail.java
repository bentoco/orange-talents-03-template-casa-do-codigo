package br.com.zupacademy.gabriel.casadocodigo.autor;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class AutorValidatorDuplicateEmail implements Validator {

    private final AutorRepository autorRepository;

    public AutorValidatorDuplicateEmail ( AutorRepository autorRepository ) {
        this.autorRepository = autorRepository;
    }

    @Override public boolean supports ( Class<?> clazz ) {
        return AutorRequest.class.isAssignableFrom(clazz);
    }

    @Override public void validate ( Object target, Errors errors ) {
        if(errors.hasErrors()){
            return;
        }

        AutorRequest request = (AutorRequest) target;

        Optional<Autor> possivelAutor = autorRepository
                .findByEmail(request.getEmail());

        if(possivelAutor.isPresent()){
            errors.rejectValue("email", null,
                    "Já existe um(a) outro(a) autor(a) com o mesmo email "
                            + request.getEmail());
        }
    }
}

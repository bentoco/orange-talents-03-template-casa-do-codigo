package br.com.zupacademy.gabriel.casadocodigo.config.validation;

import br.com.zupacademy.gabriel.casadocodigo.autor.Autor;
import br.com.zupacademy.gabriel.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.gabriel.casadocodigo.autor.AutorRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class EmailDuplicateAutorValidator implements Validator {

    private final AutorRepository autorRepository;

    public EmailDuplicateAutorValidator ( AutorRepository autorRepository ) {
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

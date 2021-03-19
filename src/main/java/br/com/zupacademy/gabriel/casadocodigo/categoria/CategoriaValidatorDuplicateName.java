package br.com.zupacademy.gabriel.casadocodigo.categoria;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class CategoriaValidatorDuplicateName implements Validator {

    private final CategoriaRepository categoriaRepository;

    public CategoriaValidatorDuplicateName ( CategoriaRepository categoriaRepository ) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override public boolean supports ( Class<?> clazz ) {
        return CategoriaRequest.class.isAssignableFrom(clazz);
    }

    @Override public void validate ( Object target, Errors errors ) {
        if(errors.hasErrors()){
            return;
        }

        CategoriaRequest request = (CategoriaRequest) target;

        Optional<Categoria> possivelNomeCategoria = categoriaRepository
                .findByNomeCategoria(request.getNomeCategoria());

        if(possivelNomeCategoria.isPresent()){
            errors.rejectValue("nomeCategoria", null, "Já existe uma categoria cadastrada com o nome " + request.getNomeCategoria());
        }
    }
}

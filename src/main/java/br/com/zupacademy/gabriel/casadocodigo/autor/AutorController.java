package br.com.zupacademy.gabriel.casadocodigo.autor;

import br.com.zupacademy.gabriel.casadocodigo.config.validation.EmailDuplicateAutorValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/autores")
public class AutorController {

    private final AutorRepository autorRepository;
    private final EmailDuplicateAutorValidator emailDuplicateAutorValidator;

    public AutorController (
            AutorRepository autorRepository,
            EmailDuplicateAutorValidator emailDuplicateAutorValidator ) {
        this.autorRepository = autorRepository;
        this.emailDuplicateAutorValidator = emailDuplicateAutorValidator;
    }

    @InitBinder
    public void init( WebDataBinder binder) {
        //1
        binder.addValidators(emailDuplicateAutorValidator);
    }

    @PostMapping
    public ResponseEntity<Autor> create( @RequestBody @Valid AutorRequest request){
        Autor autor = request.toModel();
        autorRepository.save(autor);
        return ResponseEntity.ok().build();
    }
}

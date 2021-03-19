package br.com.zupacademy.gabriel.casadocodigo.autor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/autores")
public class AutorController {

    private final AutorRepository autorRepository;
    private final AutorValidatorDuplicateEmail autorValidatorDuplicateEmail;

    public AutorController (
            AutorRepository autorRepository,
            AutorValidatorDuplicateEmail autorValidatorDuplicateEmail ) {
        this.autorRepository = autorRepository;
        this.autorValidatorDuplicateEmail = autorValidatorDuplicateEmail;
    }

    @InitBinder
    public void init( WebDataBinder binder) {
        //1
        binder.addValidators(autorValidatorDuplicateEmail);
    }

    @PostMapping
    public ResponseEntity<Autor> create( @RequestBody @Valid AutorRequest request){
        Autor autor = request.toModel();
        autorRepository.save(autor);
        return ResponseEntity.ok().build();
    }
}

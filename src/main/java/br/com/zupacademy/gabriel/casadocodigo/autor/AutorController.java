package br.com.zupacademy.gabriel.casadocodigo.autor;

import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("api/autores")
public class AutorController {

    private final AutorRepository autorRepository;

    public AutorController ( AutorRepository autorRepository ) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    @Transactional
    public String create( @RequestBody @Valid AutorRequest request){
        Autor autor = request.toModel();
        autorRepository.save(autor);
        return autor.toString();
    }
}

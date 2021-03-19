package br.com.zupacademy.gabriel.casadocodigo.autor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/autores")
public class AutorController {

    private final AutorRepository autorRepository;

    public AutorController ( AutorRepository autorRepository ) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public ResponseEntity<Autor> create( @RequestBody @Valid AutorRequest request){
        Autor autor = request.toModel();
        autorRepository.save(autor);
        return ResponseEntity.ok().build();
    }
}

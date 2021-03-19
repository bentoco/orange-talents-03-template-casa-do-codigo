package br.com.zupacademy.gabriel.casadocodigo.categoria;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaValidatorDuplicateName categoriaValidatorDuplicateName;

    public CategoriaController (
            CategoriaRepository categoriaRepository,
            CategoriaValidatorDuplicateName categoriaValidatorDuplicateName ) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaValidatorDuplicateName = categoriaValidatorDuplicateName;
    }

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(categoriaValidatorDuplicateName);
    }

    @PostMapping
    @Transactional
    public String create( @RequestBody @Valid CategoriaRequest request ){
        Categoria categoria = request.toModel();
        categoriaRepository.save(categoria);
        return categoria.toString();
    }

}

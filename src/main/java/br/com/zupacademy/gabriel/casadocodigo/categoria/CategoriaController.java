package br.com.zupacademy.gabriel.casadocodigo.categoria;

import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    public CategoriaController ( CategoriaRepository categoriaRepository ) {
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    @Transactional
    public String create( @RequestBody @Valid CategoriaRequest request ){
        Categoria categoria = request.toModel();
        categoriaRepository.save(categoria);
        return categoria.toString();
    }

}

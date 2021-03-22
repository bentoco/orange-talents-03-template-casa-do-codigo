package br.com.zupacademy.gabriel.casadocodigo.livro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @PersistenceContext
    private EntityManager manager;
    private final LivroRepository livroRepository;

    public LivroController (
            EntityManager manager ,
            LivroRepository livroRepository ) {
        this.manager = manager;
        this.livroRepository = livroRepository;
    }

    @PostMapping
    @Transactional
    public String create( @RequestBody @Valid LivroRequest request){
        Livro livro = request.toModel(manager);
        manager.persist(livro);
        return livro.toString();
    }

    /*
    * nesta parte do código temos as seguintes opções:
    *
    * - utilizar o método .findAll da interface JpaRepository,
    * porém aumentaria a carga cognitiva do meu controller
    *
    * ou
    *
    * - utilizar native SQL query com anotação para dasabilitar warning
    * com @SuppressWarnings("unchecked")
    *
    * optei por utilizar a interface Jpa Repository porque é um facilitador,
    * mas posso mudar de ideia
    * */
    @GetMapping
    public List<LivroResponseIdNome> lista(){
        List<Livro> livros = livroRepository.findAll();
        return LivroResponseIdNome.toDto(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponseById> livroById( @PathVariable Long id){
        Optional<Livro> livro = livroRepository.findById(id);
        if (livro.isPresent()) {
            return ResponseEntity.ok(new LivroResponseById(livro.get()));
        }
        return ResponseEntity.notFound().build();
    }
}

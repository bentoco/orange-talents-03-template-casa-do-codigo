package br.com.zupacademy.gabriel.casadocodigo.estado;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public String create( @RequestBody @Valid EstadoNovoRequest request ){
        Estado estado = request.toModel(manager);
        manager.persist(estado);
        return estado.toString();
    }
}

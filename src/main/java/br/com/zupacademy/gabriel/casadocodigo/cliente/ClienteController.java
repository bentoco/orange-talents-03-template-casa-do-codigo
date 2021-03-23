package br.com.zupacademy.gabriel.casadocodigo.cliente;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public String create( @RequestBody @Valid ClienteNovoRequest request ){
        Cliente novoCliente =  request.toModel(manager);
        manager.persist(novoCliente);
        return novoCliente.toString();
    }
}

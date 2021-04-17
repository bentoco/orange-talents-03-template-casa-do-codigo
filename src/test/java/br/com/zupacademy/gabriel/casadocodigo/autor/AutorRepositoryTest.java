package br.com.zupacademy.gabriel.casadocodigo.autor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ActiveProfiles ( "Test" )
class AutorRepositoryTest {

    @Autowired
    private AutorRepository repository;

    @Test
    @Transactional
    @DisplayName ( "must find author by email" )
    public void test1 () {
        Autor autor = new Autor("Robin Willians" , "foo@email.com" , "Nice autor");
        repository.save(autor);

        String email = "foo@email.com";
        Autor possivelAutor = repository.findByEmail(email).get();

        assertNotNull(possivelAutor);
        assertEquals(autor , possivelAutor);
    }
}
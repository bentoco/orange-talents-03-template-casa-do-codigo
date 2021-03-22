package br.com.zupacademy.gabriel.casadocodigo.livro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}

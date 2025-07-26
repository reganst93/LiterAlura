package com.aluralatam.LiterAlura.repository;

import com.aluralatam.LiterAlura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor,Long> {
    List<Autor> findAll();
    @Query(value = "SELECT * FROM autores a WHERE CAST(a.nacimiento AS INTEGER) <= :ano", nativeQuery = true)
    List<Autor> findAutoresNacidosAntesDeAno(@Param("ano") int ano);


}

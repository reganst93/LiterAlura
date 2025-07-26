package com.aluralatam.LiterAlura.repository;

import com.aluralatam.LiterAlura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro,Long> {

    List<Libro> findByIdiomas(String idioma);
    @Query("Select l FROM Libro l LEFT JOIN FETCH l.autores")
    List<Libro> findAllWithAutores();
}

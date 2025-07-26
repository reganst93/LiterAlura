package com.aluralatam.LiterAlura.repository;

import com.aluralatam.LiterAlura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro,Long> {

    List<Libro> findByIdiomas(String idioma);

}

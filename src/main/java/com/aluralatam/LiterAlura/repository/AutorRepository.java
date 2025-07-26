package com.aluralatam.LiterAlura.repository;

import com.aluralatam.LiterAlura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor,Long> {
    List<Autor> findAll();
    @Query("SELECT a FROM Autor a WHERE a.nacimiento <= :ano AND (a.muerte IS NULL OR a.muerte >= :ano)")
    List<Autor> findAutoresVivosEnAno(@Param("ano") int ano);

}

package com.aluralatam.LiterAlura.dto;

import java.util.List;

public record LibroDTO(
        String titulo,
        List<String> autores,
        List<String> idiomas,
        int numeroDeDescarga) {

}

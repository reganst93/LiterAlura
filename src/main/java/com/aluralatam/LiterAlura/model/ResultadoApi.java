package com.aluralatam.LiterAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultadoApi {
    @JsonAlias("results")
    private List<Libro> resultados;

    public List<Libro> getResultados(){
        return resultados;
    }

    public void  setResultados(List<Libro> resultados){
        this.resultados = resultados;
    }

}

package com.aluralatam.LiterAlura.principal;

import com.aluralatam.LiterAlura.service.ConsumoApi;
import com.aluralatam.LiterAlura.service.ConvierteDatos;

public class Principal {
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos conversor = new ConvierteDatos();


    public void muestraElMenu(){
        var json = consumoApi.obtenerDatos(URL_BASE);
        System.out.println(json);
    }

}

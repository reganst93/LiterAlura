package com.aluralatam.LiterAlura.principal;

import com.aluralatam.LiterAlura.model.Libro;
import com.aluralatam.LiterAlura.repository.LibroRepository;
import com.aluralatam.LiterAlura.service.ConsumoApi;
import com.aluralatam.LiterAlura.service.ConvierteDatos;
import org.hibernate.sql.ast.tree.cte.CteSearchClauseKind;
import com.aluralatam.LiterAlura.model.ResultadoApi;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private static final String URL_BASE = "https://gutendex.com/books/";
    private final LibroRepository repositorio;
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos conversor = new ConvierteDatos();
    private Scanner teclado = new Scanner(System.in);

    public Principal(LibroRepository repository){
        this.repositorio = repository;
    }



    public void muestraElMenu(){
        var opcion = -1;
        while ( opcion != 0){
            var menu = """
                    1 - Buscar libro por titulo
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en determinado año
                    5 - Listar libros por idioma
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){
                case 1:
                    buscarLibroPorTitulo();
                    break;
                /*case 2:
                    ListarLibrosRegistrados();
                    break;
                case 3:
                    ListarAutoresRegistrados();
                    break;
                case 4:
                    BuscarAutoresPorAnoNacimiento();
                    break;
                case 5:
                    ListarLibrosPorIdioma();
                    break;*/
                case 0:
                    System.out.println("Gracias por usar la Aplicacion, Adios");
                    break;
                default:
                    System.out.println("Opcion inválida");
            }
        }
    }

    private void buscarLibroPorTitulo() {
        System.out.println("Ingrese el título del libro a buscar");
        String titulo = teclado.nextLine();

        String url = URL_BASE + "?search=" + titulo.replace(" ", "+");

        try {
            String json = consumoApi.obtenerDatos(url);
            ResultadoApi resultado = conversor.obtenerDatos(json, ResultadoApi.class);

            if (resultado == null || resultado.getResultados() == null || resultado.getResultados().isEmpty()) {
                System.out.println("No se encontraron libros con ese título.");
            } else {

                Libro libro = resultado.getResultados().get(0);
                // Guardar libro en base de datos
                repositorio.save(libro);
                System.out.println("----------LIBRO----------");
                System.out.println("Titulo: " + libro.getTitulo());
                System.out.print("Autor(es): ");
                if (libro.getAutores() == null || libro.getAutores().isEmpty()) {
                    System.out.println("No disponible");
                } else {
                    // Listar todos los autores separados por coma
                    String autores = libro.getAutores().stream()
                            .map(a -> a.getNombre())
                            .reduce((a1, a2) -> a1 + ", " + a2)
                            .orElse("No disponible");
                    System.out.println(autores);
                };
                System.out.println("Idioma(s): ");
                if (libro.getIdiomas() == null || libro.getIdiomas().isEmpty()){
                    System.out.println("Idiomas no disponibles");
                }else {
                    String idiomas = String.join(",", libro.getIdiomas());
                    System.out.println(idiomas);
                }
                System.out.println("Número de descargas: " + libro.getNumeroDeDescargas());
                System.out.println("-------------------");

            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al buscar el libro: " + e.getMessage());
            e.printStackTrace();
        }
    }


}



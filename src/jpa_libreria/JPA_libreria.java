/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jpa_libreria;

import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;

import libreria.servicios.AutorServicio;
import libreria.servicios.EditorialServicio;
import libreria.servicios.LibroServicio;

/**
 *
 * @author USER
 */
public class JPA_libreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        AutorServicio AS = new AutorServicio();

        EditorialServicio ES = new EditorialServicio();

        LibroServicio LS = new LibroServicio();

        Scanner leer = new Scanner(System.in);
        System.out.println("MENU \n 1. Registrar (autor, editorial, libro) \n 2. Modificar (autor, editorial, libro) "
                + "\n 3. Dar de Alta o de Baja (autor, editorial, libro"
                + " \n 4. Busqueda (autor, editorial, libro) \n  Seleccione una opción ");

        int var = leer.nextInt();

        //MENU
        switch (var) {

            case 1:

                System.out.println("REGISTRAR \n 1. Autor \n 2. Editorial \n 3. Libro \n Selecciona una opción");
                int x = leer.nextInt();

                // SUB MENU REGISTRAR
                switch (x) {
                    case 1:
                        Autor a1 = AS.crearAutor();

                        break;

                    case 2:
                        Editorial e1 = ES.crearEditorial();

                        break;

                    case 3:
                        Autor a2 = AS.crearAutor();
                        Editorial e2 = ES.crearEditorial();
                        LS.crearLibro(a2, e2);
                        break;
                    default:
                        throw new AssertionError();
                        
                        
                } break;

            case 2:

                System.out.println("MODIFICAR \n 1. Autor \n 2. Editorial \n 3. Libro \n Selecciona una opción");
                int Y = leer.nextInt();

                //SUB MENU MODIFICAR
                switch (Y) {
                    case 1:
                        AS.modificarAutor();
                        break;

                    default:
                        throw new AssertionError();
                } break;

            case 3:
                System.out.println("ALTA/BAJA \n 1. Autor \n 2. Editorial \n 3. Libro \n Selecciona una opción");
                int z = leer.nextInt();

                //SUB MENU BAJA ALTA
                switch (z) {
                    case 1:
                        AS.bajaAltaAutor();
                        break;
                    default:
                        throw new AssertionError();
                } break;
                
                
                
            case 4:
                 System.out.println("BUSCAR \n 1. Autor \n 2. Editorial \n 3. Libro \n Selecciona una opción");
                int n = leer.nextInt();
                
                switch (n) {
                    case 1:
                         AS.consultarAutor();
                        break;
                    default:
                        throw new AssertionError();
                }

                break;
            default:
                throw new AssertionError();
        }

//        
//       LibroServicio ls = new LibroServicio();
//       Libro l1 = ls.crearLibro();
//        
//        em.getTransaction().begin();
//        em.persist(l1);
//        em.getTransaction().commit();
//        
//        
        //AS.consultaAutores();
//        AS.consultarAutor();
       
    }

}

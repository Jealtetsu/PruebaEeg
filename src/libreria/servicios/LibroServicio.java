/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.servicios;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;

/**
 *
 * @author USER
 */
public class LibroServicio {
    
    public Libro crearLibro(Autor a, Editorial b) {
        
        Scanner leer = new Scanner(System.in);
        Libro L1 = new Libro();
        AutorServicio AS = new AutorServicio();
        EditorialServicio ES = new EditorialServicio();
        L1.setAlta(true);
        
        EntityManager em = Persistence.createEntityManagerFactory("JPA_libreriaPU").createEntityManager();
        try {
            
            System.out.println("año del libro:");
            L1.setAnio(leer.nextInt());
            leer.nextLine();
            
            System.out.println("Título del libro");
            L1.setTitulo(leer.nextLine());
            
            System.out.println("Ingrese el número de ejemplares");
            
            L1.setAutor(a);
            L1.setEditorial(b);
            
            L1.setEjemplares(leer.nextInt());
            L1.setEjemplaresPrestadosInteger(0);
            L1.setEjemplaresRestantes(L1.getEjemplares());
            
            em.getTransaction().begin();
            em.persist(L1);
            em.getTransaction().commit();
            
            return L1;
        } catch (Exception e) {
            System.out.println("Error al crear la editorial: " + e.getMessage());
            return null;
        } finally {
            leer.close();            
            em.close();
        }
    }
    
}

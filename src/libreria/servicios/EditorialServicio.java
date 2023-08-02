/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.servicios;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidades.Editorial;

/**
 *
 * @author USER
 */
public class EditorialServicio {
    
    Scanner leer = new Scanner(System.in);
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_libreriaPU");
    
    public Editorial crearEditorial() {
        EntityManager em = emf.createEntityManager();
        Editorial e1 = new Editorial();
        
        try {
            System.out.println("Ingrese el nombre de la editorial");
            e1.setNombre(leer.nextLine());
            e1.setAlta(true);
            
            em.getTransaction().begin();
            em.persist(e1);
            em.getTransaction().commit();
            
            return e1;
        } catch (Exception e) {
            System.out.println("Error al crear la editorial: " + e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.servicios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidades.Autor;

/**
 *
 * @author USER
 */
public class AutorServicio {
    
    Scanner leer = new Scanner(System.in);
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_libreriaPU");
    EntityManager em = emf.createEntityManager();
    
    
    public Autor crearAutor() {
       
        Autor a1 = new Autor();
        
        try {
            System.out.println("Ingrese el nombre del Autor del libro");
            a1.setNombre(leer.nextLine());
            a1.setAlta(true);
            
            em.getTransaction().begin();
            em.persist(a1);
            em.getTransaction().commit();
            
            return a1;
        } catch (Exception e) {
            System.out.println("Error al crear el autor: " + e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }
    
//    
        
       public void consultarAutor(){
           
           try{
               
         
           System.out.println("Ingrese el nombre del Autor que desea buscar");
           
            Collection<Autor>autores =em.createQuery( "select a  from Autor a WHERE a.nombre LIKE '%"+leer.nextLine()+"%'").getResultList();
            for(Autor a:autores){
            System.out.println(a);
        }
           
  
             }catch(Exception e){
                 System.out.println("Eror");
             }
       }
    
    public void consultaAutores(){
        
        
            Collection<Autor>autores =em.createQuery( "select a  from Autor a ORDER BY a.nombre ASC").getResultList();
            for(Autor a:autores){
            System.out.println(a);
        }
        }
    
        public void modificarAutor(){
        
        consultaAutores();
         
            try{
               
            System.out.println("Ingrese el id del autor que desea modificar");
         
           Long id = leer.nextLong();
            long count = (long) em.createQuery("SELECT COUNT(a) FROM Autor a").getSingleResult();
           if(id>count || id<1){
               
               System.out.println(" El id ingresado no es correcto, por favor ingrese un número de id correcto");
               modificarAutor();
                return; 
           }
           
           Autor a = em.find(Autor.class, id);
           System.out.println("El nombre del autor es: "+a.getNombre()+ " ingrse el nuevo nombre del autor");
           a.setNombre(leer.next());
           
                System.out.println("Modificación de autor realizada con éxito");
                System.out.println(a);
                
              em.getTransaction().begin();
            em.merge(a);
            em.getTransaction();
                    
            }catch(Exception e){
                
        }
        }
        
        public void bajaAltaAutor(){
            
            consultaAutores();
         
            try{
                
            System.out.println("Ingrese el id del autor para cambiar el estad de ALTA");
         
           Long id = leer.nextLong();
            long count = (long) em.createQuery("SELECT COUNT(a) FROM Autor a").getSingleResult();
           if(id>count || id<1){
               
               System.out.println(" El id ingresado no es correcto, por favor ingrese un número de id correcto");
               modificarAutor();
                return; 
           }
           
           Autor a = em.find(Autor.class, id);
           
           if(a.getAlta()==true){
                a.setAlta(false);
                 System.out.println("El autor "+a.getNombre()+ " se ha dado de baja");
           }else if (a.getAlta()==false){
                     a.setAlta(false);
                     System.out.println("El autor "+a.getNombre()+ " se ha dado de alta");
                   }
           
          
          
                  
              
                System.out.println(a);
                
              em.getTransaction().begin();
            em.merge(a);
            em.getTransaction();
                    
            }catch(Exception e){
                
        }
            
        }
            
    
}

    
  

  
        
    
    
    
     
        
     
        
       
    
    

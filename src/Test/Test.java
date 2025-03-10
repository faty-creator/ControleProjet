package Test;

import beans.Etudiant;
import beans.Cours;
import beans.Inscription;
import services.EtudiantService;
import services.CoursService;
import services.InscriptionService;

import java.sql.Date;

public class Test {

    public static void main(String[] args) {
    
      CoursService coursService = new CoursService();
        
        Cours cours1 = new Cours("Mathématiques", "Prof. Dupont", "Salle 101");
        coursService.create(cours1);

        // Affichage de tous les cours après création
        System.out.println("### Liste des cours après création ###");
        for (Cours c : coursService.findAll()) {
            System.out.println(c);
        }

        // Modification d'un cours (par exemple le professeur)
        cours1.setProfesseur("Prof. Martin");
        coursService.update(cours1);

        // Affichage de tous les cours après modification
        System.out.println("### Liste des cours après modification ###");
        for (Cours c : coursService.findAll()) {
            System.out.println(c);
        }

        // Suppression d'un cours (par exemple le cours1)
        coursService.delete(cours1);

        // Affichage de tous les cours après suppression
        System.out.println("### Liste des cours après suppression ###");
        for (Cours c : coursService.findAll()) {
            System.out.println(c);
        }
        
        
        
       
        
        
        
        
        
        
    }
}

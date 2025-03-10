package test;

import beans.Etudiant;
import beans.Cours;
import beans.Inscription;
import services.EtudiantService;
import services.CoursService;
import services.InscriptionService;

import java.sql.Date;

public class Test {

    public static void main(String[] args) {
//        // Création des services
//        EtudiantService es = new EtudiantService();
//        CoursService cs = new CoursService();
//        InscriptionService is = new InscriptionService();
//
//        // Création de cours
//        Cours cours1 = new Cours("Mathematics", "Prof. A", "Salle 101");
//        Cours cours2 = new Cours("Physics", "Prof. B", "Salle 102");
//        cs.create(cours1);
//        cs.create(cours2);
//
//        // Création d'un étudiant
//        Etudiant etudiant = new Etudiant("fati", "Amal", new Date(System.currentTimeMillis()), "fai.amal@example.com");
//        es.create(etudiant);
//
//        // Inscriptions de l'étudiant à des cours
//        Inscription inscription1 = new Inscription(cours1, etudiant, new Date(System.currentTimeMillis()));
//        Inscription inscription2 = new Inscription(cours2, etudiant, new Date(System.currentTimeMillis()));
//        is.create(inscription1);
//        is.create(inscription2);
//
//        // Recherche d'un étudiant par ID et affichage de son nom
//        Etudiant etudiantTrouve = es.findById(etudiant.getId());
//        if (etudiantTrouve != null) {
//            System.out.println("Nom de l'étudiant trouvé : " + etudiantTrouve.getNom());
//        }
//
//        // Recherche d'un cours par ID et affichage de son intitulé
//        Cours coursTrouve = cs.findById(cours1.getId());
//        if (coursTrouve != null) {
//            System.out.println("Cours trouvé : " + coursTrouve.getIntitule());
//        }
//
//        // Recherche d'une inscription par ID et affichage de l'étudiant et du cours
//        Inscription inscriptionTrouvee = is.findById(inscription1.getId());
//        if (inscriptionTrouvee != null) {
//            System.out.println("Inscription trouvée : Etudiant = " + inscriptionTrouvee.getEtudiant().getNom() +
//                    ", Cours = " + inscriptionTrouvee.getCours().getIntitule());
//        }
//
//        // Suppression d'une inscription
//        is.delete(inscription1);
//
//        // Suppression d'un étudiant
//        es.delete(etudiant);
//
//        // Suppression de cours
//        cs.delete(cours1);
//        cs.delete(cours2);
//
//        // Affichage de tous les étudiants après suppression
//        System.out.println("Liste des étudiants après suppression : ");
//        for (Etudiant e : es.findAll()) {
//            System.out.println("Nom de l'étudiant : " + e.getNom());
//        }
//
//        // Affichage de tous les cours après suppression
//        System.out.println("Liste des cours après suppression : ");
//        for (Cours c : cs.findAll()) {
//            System.out.println("Cours : " + c.getIntitule());
//        }
    }
}

package ma.projet.test;

import beans.Etudiant;
import beans.Cours;
import beans.Inscription;
import services.EtudiantService;
import services.CoursService;
import services.InscriptionService;
import java.sql.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        // Création des services
        EtudiantService es = new EtudiantService();
        CoursService cs = new CoursService();
        InscriptionService is = new InscriptionService();
        
        // Création des cours
        cs.create(new Cours("java", "lachgar.mohammed", "i1"));
        cs.create(new Cours("didactique", "n.zahid", "i2"));
        cs.create(new Cours("developpement", "o.stitini", "i3"));

        // Création des étudiants
        es.create(new Etudiant("khalfi", "ali", Date.valueOf("2000-01-01"), "k.ali@gmail.com"));
        es.create(new Etudiant("ben", "sara", Date.valueOf("2001-02-02"), "b.sara@gmail.com"));
        es.create(new Etudiant("alhay", "aya", Date.valueOf("2002-03-03"), "a.aya@gmail.com"));
        // Création des inscriptions
        is.create(new Inscription(cs.findById(3), es.findById(14), new java.util.Date()));

       
        // Liste des étudiants après ajout
        System.out.println("### Liste des étudiants après ajout ###");
        List<Etudiant> etudiants = es.findAll();
        for (Etudiant e : etudiants) {
            System.out.println(e);
        }
        
        // Modifier un étudiant (changer son nom)
        Etudiant etudiantModif = es.findById(1);
        if (etudiantModif != null) {
            etudiantModif.setNom("Khalfi-Mohammed");
            es.update(etudiantModif);
            System.out.println("### Etudiant modifié ###");
            System.out.println(etudiantModif);
        }

        // Supprimer un étudiant
        Etudiant etudiantASupprimer = es.findById(3); // Suppression de l'étudiant avec ID 3
        if (etudiantASupprimer != null) {
            es.delete(etudiantASupprimer);
            System.out.println("### Etudiant supprimé ###");
            System.out.println(etudiantASupprimer);
        }

        // Inscrire un étudiant à un cours
        Etudiant etudiantInscrit = es.findById(1); // Etudiant avec id 1
        Cours coursInscription = cs.findById(1);  // Cours avec id 1
        if (etudiantInscrit != null && coursInscription != null) {
            Inscription inscription = new Inscription(coursInscription, etudiantInscrit, new Date(System.currentTimeMillis()));
            is.create(inscription);
            System.out.println("### Inscription ajoutée ###");
            System.out.println(inscription);
        }

        // Filtrer les étudiants inscrits dans le cours Java
        System.out.println("### Étudiants inscrits dans le cours Java ###");
        List<Etudiant> etudiantsInJava = is.findEtudiantByCourse(1);  // 1 = ID du cours Java
        for (Etudiant e : etudiantsInJava) {
            System.out.println(e);
        }

        // Rechercher un étudiant par nom
        String nomRecherche = "Khalfi";
        Etudiant etudiantTrouve = es.findByNom(nomRecherche);
        if (etudiantTrouve != null) {
            System.out.println("### Étudiant trouvé ###");
            System.out.println(etudiantTrouve);
        } else {
            System.out.println("### Aucun étudiant trouvé avec le nom " + nomRecherche + " ###");
        }

      
        // Afficher les inscriptions de tous les étudiants
        System.out.println("### Liste des inscriptions ###");
        List<Inscription> inscriptions = is.findAll();
        for (Inscription i : inscriptions) {
            System.out.println(i.getEtudiant().getNom() + " -> " + i.getCours().getIntitule());
        }
        

    }
}
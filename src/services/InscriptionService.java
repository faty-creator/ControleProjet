package services;

import connexion.Connexion;
import dao.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.Etudiant;
import beans.Cours;
import beans.Inscription;
import java.sql.Date;

public class InscriptionService implements IDao<Inscription> {

    private Connexion connexion;
    private EtudiantService etudiantService;
    private CoursService coursService;

    public InscriptionService() {
        connexion = Connexion.getInstance();
        etudiantService = new EtudiantService();
        coursService = new CoursService();
    }

    @Override
    public boolean create(Inscription inscription) {
        String req = "INSERT INTO inscription ( cours_id,etudiant_id, date_inscription) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, inscription.getCours().getId());
            ps.setInt(2, inscription.getEtudiant().getId());

            ps.setDate(3, new Date(inscription.getDateInscription().getTime()));
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Inscription inscription) {
        String req = "DELETE FROM inscription WHERE etudiant_id = ? AND cours_id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, inscription.getEtudiant().getId());
            ps.setInt(2, inscription.getCours().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Inscription inscription) {
        String req = "UPDATE inscription SET etudiant_id = ?, cours_id = ?, date_inscription = ? WHERE etudiant_id = ? AND cours_id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, inscription.getEtudiant().getId());
            ps.setInt(2, inscription.getCours().getId());
            ps.setDate(3, new java.sql.Date(inscription.getDateInscription().getTime()));
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Inscription findById(int id) {
        return null;
    }

    @Override
    public List<Inscription> findAll() {
        List<Inscription> inscriptions = new ArrayList<>();
        String req = "SELECT * FROM inscription";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Etudiant etudiant = etudiantService.findById(rs.getInt("etudiant_id"));

                Cours cours = coursService.findById(rs.getInt("cours_id"));

                Date dateInscription = rs.getDate("date_inscription");

                inscriptions.add(new Inscription(cours, etudiant, dateInscription));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return inscriptions;

    }
//    methode findEtudiantByCourse

   public List<Etudiant> findEtudiantByCourse(Cours cours) {
    List<Etudiant> etudiants = new ArrayList<>();
    // Requête SQL utilisant l'intitulé du cours pour filtrer les étudiants
    String req = "SELECT e.* FROM étudiant e "
               + "JOIN inscription i ON e.id = i.etudiant_id "
               + "JOIN cours c ON i.cours_id = c.id "
               + "WHERE c.intitule = ?";  // On filtre ici par l'intitulé du cours
    
    try {
        // Préparer la requête SQL
        PreparedStatement ps = connexion.getCn().prepareStatement(req);
        ps.setString(1, cours.getIntitule()); // On passe l'intitulé du cours
        ResultSet rs = ps.executeQuery();
        
        // Parcourir le résultat et ajouter les étudiants à la liste
        while (rs.next()) {
            Etudiant etudiant = new Etudiant(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getString("prenom"),
                rs.getDate("date_naissance"),
                rs.getString("email")
            );
            etudiants.add(etudiant);
        }
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la récupération des étudiants : " + ex.getMessage());
    }
    
    // Afficher le nombre d'étudiants trouvés pour ce cours
    System.out.println("Nombre d'étudiants trouvés pour le cours " + cours.getIntitule() + " : " + etudiants.size());
    return etudiants;
}


//    methode findCourseByStudent
    public List<Cours> findCourseByStudent(Etudiant etudiant) {
        List<Cours> coursList = new ArrayList<>();
        String req = "SELECT c.* FROM cours c JOIN inscription i ON c.id = i.cours_id WHERE i.etudiant_id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);

            ps.setInt(1, etudiant.getId());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cours cours = new Cours(
                        rs.getInt("id"),
                        rs.getString("intitule"),
                        rs.getString("professeur"),
                        rs.getString("salle")
                );
                coursList.add(cours);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération des cours : " + ex.getMessage());
        }
        return coursList;
    }
  

}

package services;

import beans.Etudiant;
import beans.Inscription;
import connexion.Connexion;
import dao.IDao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EtudiantService implements IDao<Etudiant> {

    private Connexion connexion;
    private InscriptionService inscriptionService;  // Service pour gérer les inscriptions

    public EtudiantService() {
        connexion = Connexion.getInstance();
        inscriptionService = new InscriptionService();  // Initialisation du service des inscriptions
    }

    @Override
    public boolean create(Etudiant o) {
        String req = "INSERT INTO étudiant (id, nom, prenom, date_naissance, email) VALUES (null, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setDate(3, o.getDateNaissance());
            ps.setString(4, o.getEmail());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

   public boolean delete(Etudiant o) {
    // Supprimer directement les inscriptions liées à l'étudiant
    String req = "DELETE FROM inscription WHERE etudiant_id = ?";
    try {
        PreparedStatement ps = connexion.getCn().prepareStatement(req);
        ps.setInt(1, o.getId());
        ps.executeUpdate();
        
        // Ensuite, supprimer l'étudiant
        String deleteStudentReq = "DELETE FROM étudiant WHERE id = ?";
        ps = connexion.getCn().prepareStatement(deleteStudentReq);
        ps.setInt(1, o.getId());
        ps.executeUpdate();
        return true;
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return false;
}


    @Override
    public boolean update(Etudiant o) {
        String req = "UPDATE étudiant SET nom = ?, prenom = ?, date_naissance = ?, email = ? WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setDate(3, new Date(o.getDateNaissance().getTime()));
            ps.setString(4, o.getEmail());
            ps.setInt(5, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Etudiant findById(int id) {
        String req = "SELECT * FROM étudiant WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Etudiant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"),
                        rs.getDate("date_naissance"), rs.getString("email"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Etudiant> findAll() {
        List<Etudiant> etudiants = new ArrayList<>();
        String req = "SELECT * FROM étudiant";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Etudiant etudiant = new Etudiant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"),
                        rs.getDate("date_naissance"), rs.getString("email"));
                etudiants.add(etudiant);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return etudiants;
    }
}

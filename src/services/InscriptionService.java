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
        String req = "INSERT INTO inscription (etudiant_id, cours_id, date_inscription) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, inscription.getEtudiant().getId());
            ps.setInt(2, inscription.getCours().getId());
            ps.setDate(3, inscription.getDateInscription());
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
            ps.setDate(3, inscription.getDateInscription());
            ps.setInt(4, inscription.getEtudiant().getId());
            ps.setInt(5, inscription.getCours().getId());
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
}

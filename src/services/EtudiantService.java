package services;

import beans.Etudiant;
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

    public EtudiantService() {
        connexion = Connexion.getInstance(); // Initialisation de la connexion
        if (connexion == null || connexion.getCn() == null) {
            System.out.println("Erreur de connexion à la base de données !");
        } else {
            System.out.println("Connexion réussie !");
        }
    }

    @Override
    public boolean create(Etudiant o) {
        if (connexion == null || connexion.getCn() == null) {
            System.out.println("La connexion à la base de données n'est pas initialisée.");
            return false;
        }

        String req = "INSERT INTO étudiant(id, nom, prenom, date_naissance, email) VALUES (null, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setDate(3, o.getDateNaissance());
            ps.setString(4, o.getEmail());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la création de l'étudiant : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Etudiant o) {
        if (connexion == null || connexion.getCn() == null) {
            System.out.println("La connexion à la base de données n'est pas initialisée.");
            return false;
        }

        String req = "DELETE FROM étudiant WHERE id = ?"; // Correction : Supprimer de la table étudiant
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la suppression de l'étudiant : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Etudiant o) {
        if (connexion == null || connexion.getCn() == null) {
            System.out.println("La connexion à la base de données n'est pas initialisée.");
            return false;
        }

        String req = "UPDATE étudiant SET nom = ?, prenom = ?, date_naissance = ?, email = ? WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setDate(3, new java.sql.Date(o.getDateNaissance().getTime()));
            ps.setString(4, o.getEmail());
            ps.setInt(5, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la mise à jour de l'étudiant : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public Etudiant findById(int id) {
        if (connexion == null || connexion.getCn() == null) {
            System.out.println("La connexion à la base de données n'est pas initialisée.");
            return null;
        }

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
            System.out.println("Erreur lors de la recherche de l'étudiant par ID : " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Etudiant> findAll() {
        if (connexion == null || connexion.getCn() == null) {
            System.out.println("La connexion à la base de données n'est pas initialisée.");
            return new ArrayList<>();
        }

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
            System.out.println("Erreur lors de la récupération de tous les étudiants : " + ex.getMessage());
        }
        return etudiants;
    }

    public Etudiant findByNom(String nom) {
        if (connexion == null || connexion.getCn() == null) {
            System.out.println("La connexion à la base de données n'est pas initialisée.");
            return null;
        }

        String req = "SELECT * FROM étudiant WHERE nom = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, nom);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Etudiant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"),
                        rs.getDate("date_naissance"), rs.getString("email"));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la recherche de l'étudiant par nom : " + ex.getMessage());
        }
        return null;
    }
}
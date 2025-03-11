package services;

import beans.Cours;
import connexion.Connexion;
import dao.IDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoursService implements IDao<Cours> {
    private Connexion connexion;

    public CoursService() {
        connexion = Connexion.getInstance();
    
    
    if (connexion == null || connexion.getCn() == null) {
        System.out.println("Erreur de connexion à la base de données !");
    } else {
        System.out.println("Connexion réussie !");
    }
    }

    @Override
    public boolean create(Cours o) {
        String req = "INSERT INTO cours (id, intitule, professeur, salle) VALUES (NULL, ?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getIntitule());
            ps.setString(2, o.getProfesseur());
            ps.setString(3, o.getSalle());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Cours o) {
        String req = "DELETE FROM cours WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Cours o) {
        String req = "UPDATE cours SET intitule = ?, professeur = ?, salle = ? WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getIntitule());
            ps.setString(2, o.getProfesseur());
            ps.setString(3, o.getSalle());
            ps.setInt(4, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Cours findById(int id) {
        String req = "SELECT * FROM cours WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Cours(rs.getInt("id"), rs.getString("intitule"), rs.getString("professeur"), rs.getString("salle"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Cours> findAll() {
        List<Cours> coursList = new ArrayList<>();
        String req = "SELECT * FROM cours";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                coursList.add(new Cours(rs.getInt("id"), rs.getString("intitule"), rs.getString("professeur"), rs.getString("salle")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return coursList;
    }
}

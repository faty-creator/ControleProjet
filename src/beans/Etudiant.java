package beans;

import java.sql.*;

public class Etudiant {

    private int id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String email;

    public Etudiant(int id, String nom, String prenom, Date dateNaissance, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.email = email;
    }

    public Etudiant(String nom, String prenom, Date date_naissance, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = date_naissance;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Etudiant{id=" + id + ", nom='" + nom + "', prenom='" + prenom + "', dateNaissance='" + dateNaissance + "', email='" + email + "'}";
    }
}

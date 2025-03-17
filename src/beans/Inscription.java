package beans;

import java.util.Date;

public class Inscription {

    private Cours cours;
    private Etudiant etudiant;
    private Date dateInscription;

    public Inscription(Cours cours, Etudiant etudiant, Date dateInscription) {
        this.cours = cours;
        this.etudiant = etudiant;
        this.dateInscription = dateInscription;
    }

    public Inscription(int etudiantId, int coursId, java.sql.Date dateInscription) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    @Override
    public String toString() {
        return  cours.getIntitule();
    }

   

}

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
        return "Inscription{" +
                "cours=" + cours.getId() + ", " + 
                "etudiant=" + etudiant.getId() + ", " +
                "dateInscription=" + dateInscription +
                '}';
    }

    
}

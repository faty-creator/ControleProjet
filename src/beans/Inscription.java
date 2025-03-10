package beans;

import java.sql.Date;

public class Inscription {
    private Cours cours;
    private Etudiant etudiant;
    private Date dateInscription;

    // Constructeur avec cours, étudiant, et date d'inscription
    public Inscription(Cours cours, Etudiant etudiant, Date dateInscription) {
        this.cours = cours;
        this.etudiant = etudiant;
        this.dateInscription = dateInscription;
    }

    // Getter et setter pour chaque attribut
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
                "cours=" + cours.getId() + ", " + // ou cours.getIntitule() si vous souhaitez afficher le nom du cours
                "etudiant=" + etudiant.getId() + ", " + // ou etudiant.getNom() si vous voulez afficher le nom de l'étudiant
                "dateInscription=" + dateInscription +
                '}';
    }
}

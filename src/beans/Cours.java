/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Classe Cours
package beans;

import java.util.Objects;

public class Cours {

    private int id;
    private String intitule;
    private String professeur;
    private String salle;

    public Cours(int id, String intitule, String professeur, String salle) {
        this.id = id;
        this.intitule = intitule;
        this.professeur = professeur;
        this.salle = salle;
    }

    public Cours(String intitule, String professeur, String salle) {
        this.intitule = intitule;
        this.professeur = professeur;
        this.salle = salle;
    }

    public int getId() {
        return id;
    }

    public String getIntitule() {
        return intitule;
    }

    public String getProfesseur() {
        return professeur;
    }

    public String getSalle() {
        return salle;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public void setProfesseur(String professeur) {
        this.professeur = professeur;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    @Override
    public String toString() {
        return  intitule ;
}
    @Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Cours cours = (Cours) o;
    return id == cours.id;
}

@Override
public int hashCode() {
    return Objects.hash(id);
}



}
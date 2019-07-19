package dev.service;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CollegueLight {

    @Id
    private String matricule;
    private String nom;
    private String prenom;
    private String photoUrl;
  
    
    public CollegueLight() {
    }
    
    public CollegueLight(String matricule, String nom, String prenom, String photoUrl) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.photoUrl = photoUrl;
    }
    public String getMatricule() {
        return matricule;
    }
    public String setMatricule(String matricule) {
        return this.matricule = matricule;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public String getPhotoUrl() {
        return photoUrl;
    }
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
    @Override
    public String toString() {
        return "matricule : " + matricule + ", nom=" + nom + ", prenom=" + prenom + ", photoUrl=" + photoUrl + "]";
    }
    
    
}

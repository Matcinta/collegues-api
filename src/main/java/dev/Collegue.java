package dev;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Entity
public class Collegue {

    @Id
    private String matricule;
    private String nom;
    private String prenom;
    private String email;
    private LocalDate dateDeNaissance;
    private String photoUrl;
  
    
    public Collegue() {
        this.matricule = UUID.randomUUID().toString();
    }
    
    public Collegue(String nom, String prenom, String email, LocalDate dateDeNaissance,
            String photoUrl) {
        super();
        this.matricule = UUID.randomUUID().toString();
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateDeNaissance = dateDeNaissance;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }
    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }
    public String getPhotoUrl() {
        return photoUrl;
    }
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
    @Override
    public String toString() {
        return "matricule : " + matricule + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
                + ", dateDeNaissance=" + dateDeNaissance + ", photoUrl=" + photoUrl + "]";
    }
    
    
    
    
}

package dev;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

@Entity
public class Collegue {

    @Id
    private String matricule;
    private String nom;
    private String prenom;
    private String email;
    private LocalDate dateDeNaissance;
    private String photoUrl;
    
    private String motDePasse;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();
    
  
    
    public Collegue() {
        this.matricule = UUID.randomUUID().toString();
    }
    
    public Collegue(String email, String password, List<String> roles) {
        this.email = email;
        this.motDePasse = password;
        this.roles = roles;
      }
    
    public Collegue(String nom, String prenom, String email, LocalDate dateDeNaissance,
            String photoUrl) {
        this();
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateDeNaissance = dateDeNaissance;
        this.photoUrl = photoUrl;
       
    }
     
    
    public Collegue(String nom, String prenom, String email, LocalDate dateDeNaissance, String photoUrl,
            String motDePasse, List<String> roles) {
        this(nom, prenom, email, dateDeNaissance, photoUrl);
        this.motDePasse = motDePasse;
        this.roles = roles;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
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

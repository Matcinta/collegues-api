package dev.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;
import dev.Collegue;
import dev.CollegueRepository;

@Repository
public class CollegueService {

    private static final int TAILLE_EMAIL_MINIMUM = 3;
    private static final int TAILLE_PRENOM_MINIMUM = 2;
    private static final int TAILLE_NOM_MINIMUM = 2;
    private static final int AGE_MINIMUM = 18;

    @Autowired
    private CollegueRepository collegueRepository;

    public CollegueService() {

    }

    public List<Collegue> lister() {
        return collegueRepository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void creer(String nom, String prenom, String email, LocalDate dateDeNaissance, String photoUrl) {
        Collegue collegue = new Collegue(nom, prenom, email, dateDeNaissance, photoUrl);
        collegueRepository.save(collegue);
    }

    public List<Collegue> chercherParNom(String nom) {
        return collegueRepository.findByNom(nom);
    }

    public Collegue chercherParMatricule(String matricule) {
        return collegueRepository.findByMatricule(matricule).orElseThrow(() -> new CollegueNonTrouveException());
    }

    public Collegue ajouterUnCollegue(Collegue collegueAAjouter) {

        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = collegueAAjouter.getDateDeNaissance();
        Period period = Period.between(birthDate, currentDate);

        // TODO Vérifier que le nom et les prenoms ont chacun au moins 2 caractères
        if (collegueAAjouter.getNom().length() < TAILLE_NOM_MINIMUM) {
            throw new CollegueInvalideException("Erreur de saisi sur  le nom");
        }
        if (collegueAAjouter.getPrenom().length() < TAILLE_PRENOM_MINIMUM) {
            throw new CollegueInvalideException("Erreur de saisi sur  le prénom");
        }

        // TODO Vérifier que l'email a au moins 3 caractères et contient `@`
        else if (collegueAAjouter.getEmail().length() < TAILLE_EMAIL_MINIMUM || !collegueAAjouter.getEmail().contains("@")) {
            throw new CollegueInvalideException("Erreur de saisi sur  le mail");
        }

        // TODO Vérifier que la photoUrl commence bien par `http`
        else if (!collegueAAjouter.getPhotoUrl().contains("http")) {
            throw new CollegueInvalideException("Erreur de saisi sur  le lien");
        }

        // TODO Vérifier que la date de naissance correspond à un age >= 18
        else if (period.getYears() < AGE_MINIMUM) {
            throw new CollegueInvalideException();
        }

        // TODO Si une des règles ci-dessus n'est pas valide, générer une exception :
        // `CollegueInvalideException`.

        // TODO générer un matricule pour ce collègue (`UUID.randomUUID().toString()`)
        String matricule = collegueAAjouter.setMatricule(UUID.randomUUID().toString());

        // TODO Sauvegarder le collègue
        collegueRepository.save(collegueAAjouter);
        return collegueAAjouter;

    }

    public Collegue modifierEmail(String matricule, String email) {

        Collegue collegue = chercherParMatricule(matricule);
        // TODO retourner une exception `CollegueNonTrouveException`
        // si le matricule ne correspond à aucun collègue
        if (!matricule.equals(matricule)) {
            throw new CollegueNonTrouveException();
        }

        // TODO Vérifier que l'email a au moins 3 caractères et contient `@`
        else if (email.length() < TAILLE_EMAIL_MINIMUM || !email.contains("@")) {
            throw new CollegueInvalideException("Erreur de saisi sur  le mail");
        }
        // TODO Si la règle ci-dessus n'est pas valide, générer une exception :
        // `CollegueInvalideException`. avec un message approprié.

        collegue.setEmail(email);
        // TODO Modifier le collègue
        collegueRepository.save(collegue);

        return collegue;
    }

    public Collegue modifierPhotoUrl(String matricule, String photoUrl) {

        Collegue collegue = chercherParMatricule(matricule);

        // TODO retourner une exception `CollegueNonTrouveException`
        // si le matricule ne correspond à aucun collègue
        if (!matricule.equals(matricule)) {
            throw new CollegueNonTrouveException();
        }

        // TODO Vérifier que la photoUrl commence bien par `http`
        if (!photoUrl.contains("http")) {
            throw new CollegueInvalideException();
        }
        // TODO Si la règle ci-dessus n'est pas valide, générer une exception :
        // `CollegueInvalideException`. avec un message approprié.
        collegue.setPhotoUrl(photoUrl);

        // TODO Modifier le collègue
        collegueRepository.save(collegue);
        return collegue;
    }

}
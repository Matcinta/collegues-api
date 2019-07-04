package dev.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Set;
import java.util.UUID;

import dev.Collegue;

public class CollegueService {

    private static final int TAILLE_EMAIL_MINIMUM = 3;
    private static final int TAILLE_PRENOM_MINIMUM = 2;
    private static final int TAILLE_NOM_MINIMUM = 2;
    private static final int AGE_MINIMUM = 18;
    private Map<String, Collegue> data = new HashMap<>();

    public CollegueService() {
        Collegue collegue1 = new Collegue("Dupont", "Paul", "paul.dupont@dta.com", LocalDate.of(1987, 7, 21),
                "http://photo/collegue1");
        Collegue collegue2 = new Collegue("Durand", "Jean", "jean.durand@dta.com", LocalDate.of(1997, 6, 14),
                "http://photo/collegue2");
        Collegue collegue3 = new Collegue("Morin", "Bob", "bob.morin@dta.com", LocalDate.of(1989, 9, 2),
                "http://photo/collegue3");
        Collegue collegue4 = new Collegue("Dupont", "Laurent", "laurent.dupont@dta.com", LocalDate.of(1987, 7, 21),
                "http://photo/collegue2");

        data.put(collegue1.getMatricule(), collegue1);
        data.put(collegue2.getMatricule(), collegue2);
        data.put(collegue3.getMatricule(), collegue3);
        data.put(collegue4.getMatricule(), collegue4);

    }

    public List<Collegue> rechercherParNom(String nomRecherche) {

        List<Collegue> listeCollegues = new ArrayList<>();

        Set<Entry<String, Collegue>> entrySet = data.entrySet();

        for (Entry<String, Collegue> entry : entrySet) {
            Collegue collegue = entry.getValue();

            if (collegue.getNom().equals(nomRecherche))
                listeCollegues.add(collegue);
        }

        return listeCollegues;

    }

    public Collegue rechercheParMatricule(String matricule) throws CollegueNonTrouveException {
        if (!data.containsKey(matricule)) {
            throw new CollegueNonTrouveException();
        }
        return data.get(matricule);
        
    }
    
    
    public Collegue ajouterUnCollegue (Collegue collegueAAjouter) {
       
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = collegueAAjouter.getDateDeNaissance();
        Period period = Period.between(birthDate, currentDate);
        
        // TODO Vérifier que le nom et les prenoms ont chacun au moins 2 caractères
        if (collegueAAjouter.getNom().length() < TAILLE_NOM_MINIMUM || collegueAAjouter.getPrenom().length() < TAILLE_PRENOM_MINIMUM) {
            throw new CollegueInvalideException();
        }
        
        // TODO Vérifier que l'email a au moins 3 caractères et contient `@`
        else if (collegueAAjouter.getEmail().length() < TAILLE_EMAIL_MINIMUM || !collegueAAjouter.getEmail().contains("@") ) {
            throw new CollegueInvalideException();
        }
        
        // TODO Vérifier que la photoUrl commence bien par `http`
        else if (!collegueAAjouter.getPhotoUrl().contains("http")) {
            throw new CollegueInvalideException();
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
        data.put(matricule, collegueAAjouter);
    	return collegueAAjouter;
   
    }
    
    
    public Collegue modifierEmail(String matricule, String email) {

        // TODO retourner une exception `CollegueNonTrouveException`
        //  si le matricule ne correspond à aucun collègue
        if (!matricule.equals(matricule)) {
            throw new CollegueNonTrouveException();
        }

       // TODO Vérifier que l'email a au moins 3 caractères et contient `@`
        else if (email.length() < TAILLE_EMAIL_MINIMUM || !email.contains("@") ) {
            
        }
       // TODO Si la règle ci-dessus n'est pas valide, générer une exception :
       // `CollegueInvalideException`. avec un message approprié.


       // TODO Modifier le collègue
        
        return null;
   }


   public Collegue modifierPhotoUrl(String matricule, String photoUrl) {

       Collegue collegue = rechercheParMatricule(matricule);
       
        // TODO retourner une exception `CollegueNonTrouveException`
        //  si le matricule ne correspond à aucun collègue
       if (!matricule.equals(matricule)) {
           throw new CollegueNonTrouveException();
       }

       // TODO Vérifier que la photoUrl commence bien par `http`
       if (!photoUrl.contains("http")) {
           throw new CollegueInvalideException();
       } 
       // TODO Si la règle ci-dessus n'est pas valide, générer une exception :
       // `CollegueInvalideException`. avec un message approprié.
       else 


       // TODO Modifier le collègue
       return null;
   }
    
    
    
    
}
package dev.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


import dev.Collegue;

public class CollegueService {

    private Map<String, Collegue> data = new HashMap<>();
    
 

    public CollegueService() {
        Collegue collegue1 = new Collegue ("Dupont", "Paul", "paul.dupont@dta.com", LocalDate.of(1987, 7, 21), "/photo/collegue1");
        Collegue collegue2 = new Collegue ("Durand", "Jean", "jean.durand@dta.com", LocalDate.of(1997, 6, 14), "/photo/collegue2");
        Collegue collegue3 = new Collegue ("Morin", "Bob", "bob.morin@dta.com", LocalDate.of(1989, 9, 2), "/photo/collegue3");
        Collegue collegue4 = new Collegue ("Dupont", "Laurent", "laurent.dupont@dta.com", LocalDate.of(1987, 7, 21), "/photo/collegue2");

        data.put(collegue1.getMatricule(), collegue1);
        data.put(collegue2.getMatricule(), collegue2);
        data.put(collegue3.getMatricule(), collegue3);
        data.put(collegue4.getMatricule(), collegue4);
        
    }

    
    public List<Collegue> rechercherParNom(String nomRecherche) {
    
        List<Collegue> listeCollegues = new ArrayList<>();
        
        Set<Entry<String,Collegue>> entrySet = data.entrySet();
        
        for (Entry<String, Collegue> entry : entrySet) {
            Collegue collegue = entry.getValue();
            
       if (collegue.getNom().equals(nomRecherche))
           listeCollegues.add(collegue);
        }
        
        return listeCollegues;
      
    }
    
}
package dev.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.Collegue;
import dev.CollegueRepository;

@Component
public class StartupDataInit {

        @Autowired
        CollegueRepository collegueRepo;
      
        static final List<String> listeNomsColleguesInit = Arrays.asList("MARTIN",
                                                    "BERNARD",
                                                    "THOMAS",
                                                    "PETIT",
                                                    "ROBERT",
                                                    "RICHARD",
                                                    "DURAND",
                                                    "DUBOIS",
                                                    "MOREAU",
                                                    "LAURENT",
                                                    "SIMON",
                                                    "MICHEL",
                                                    "LEFEBVRE",
                                                    "LEROY",
                                                    "ROUX",
                                                    "DAVID",
                                                    "BERTRAND",
                                                    "MOREL",
                                                    "FOURNIER",
                                                    "GIRARD",
                                                    "BONNET",
                                                    "DUPONT",
                                                    "LAMBERT",
                                                    "FONTAINE",
                                                    "ROUSSEAU",
                                                    "VINCENT",
                                                    "MULLER",
                                                    "LEFEVRE",
                                                    "FAURE",
                                                    "ANDRE",
                                                    "MERCIER");
        
        static final List<String> listePrenomsColleguesInit = Arrays.asList("MARTIN",
                "Vita",
                "Louise",
                "Nuria",
                "Marie",
                "LAURENT",
                "SIMON",
                "MICHELLE",
                "Simone", 
                "DAVID",
                "BERTRAND",
                "LAMBERT",
                "VINCENT",
                "ANDRE");
        
        // La méthode init va être invoquée au démarrage de l'application.
        @EventListener(ContextRefreshedEvent.class)
        public void init() {
            
        Random r = new Random();  
        for(int i = 0; i<50; i++) {
            collegueRepo.save(new Collegue(listeNomsColleguesInit.get(r.nextInt(listeNomsColleguesInit.size())),
                    listePrenomsColleguesInit.get(r.nextInt(listePrenomsColleguesInit.size())), "nom.prenom@gmail.com", LocalDate.of(r.nextInt(50)+1970, r.nextInt(12)+1, r.nextInt(28)+1), "https://www.w3schools.com/howto/img_avatar2.png"));
            
        }
            
        }
    }
package dev.service;

import java.time.LocalDate;

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
      

        // La méthode init va être invoquée au démarrage de l'application.
        @EventListener(ContextRefreshedEvent.class)
        public void init() {

            Collegue collegue1 = new Collegue("Dupont", "Roger", "roger.dupont@gmail.com", LocalDate.of(1978, 10, 21), "http://monimage.fr");
            Collegue collegue2 = new Collegue("Wijaya", "Vita", "vita.wijaya@gmail.com", LocalDate.of(1998, 5, 14), "http://tonimage.fr");
            Collegue collegue3 = new Collegue("Diawara", "Fatoumata", "fatoumata.diawara@gmail.com", LocalDate.of(1999, 1, 12), "http://sonimage.fr");
            Collegue collegue4 = new Collegue("Picasso", "Pablo", "pablo.picasso@gmail.com", LocalDate.of(2001, 12, 31), "http://vosimages.fr");
            
            collegueRepo.save(collegue1);
            collegueRepo.save(collegue2);
            collegueRepo.save(collegue3);
            collegueRepo.save(collegue4);
        }
    }
package dev.service;


import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import dev.Collegue;
import dev.util.Constantes;


public class CollegueServiceTest {

    
    private CollegueService collegueService;
    
    
    @BeforeEach
    public void setUp() {
        this.collegueService = new CollegueService();
    }
    
    
    @Test
    public void testNomCollegueNombreCaracteres() throws CollegueInvalideException {
        
        Collegue collegue = new Collegue("a", "Chouette", "bidule.chouette@gmail.com", LocalDate.of(2000, 3, 4), "http://monimage");
        assertThrows(CollegueInvalideException.class, () -> collegueService.ajouterUnCollegue(collegue));
    }
    
    @Test
    public void testPrenomCollegueNombreCaracteres() throws CollegueInvalideException {
        
        Collegue collegue = new Collegue("Bidule", "a", "bidule.chouette@gmail.com", LocalDate.of(2000, 3, 4), "http://monimage");
        assertThrows(CollegueInvalideException.class, () -> collegueService.ajouterUnCollegue(collegue));
    }
    
    
    
}

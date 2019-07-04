package dev.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.Collegue;
import dev.service.CollegueInvalideException;
import dev.service.CollegueNonTrouveException;
import dev.service.CollegueService;
import dev.util.Constantes;

@RestController
@RequestMapping("/collegue")
public class CollegueController {

    private CollegueService collegueService = Constantes.COLLEGUE_SERVICE;

    @RequestMapping(
            method = RequestMethod.GET
            )

    public List<String> recupMatricule(@RequestParam String nom) {

        List<String> matricules = collegueService.rechercherParNom(nom)
                .stream()
                .map(c -> c.getMatricule()) // on peut écrire .map(Collegue::getMatricule)
                .collect(Collectors.toList()); // on peut écrire .collect(toList()); en important import static collectors

        return matricules;

    }

    @RequestMapping(
            method = RequestMethod.GET, 
            path = "/{matricule}")

    public Collegue recupCollegueFromMatricule(@PathVariable String matricule) {

        Collegue collegue = Constantes.COLLEGUE_SERVICE.rechercheParMatricule(matricule);
        return collegue;

    }

    @RequestMapping(
            method = RequestMethod.POST
            )

    public Collegue newCollegue(@RequestBody Collegue collegue) {

        Collegue newCollegue = Constantes.COLLEGUE_SERVICE.ajouterUnCollegue(collegue);

        return newCollegue;

    }
    
    @RequestMapping(
            method = RequestMethod.PATCH,
            path = "/{matricule}"
            )
    
    public Collegue updateCollegue (@PathVariable String matricule,
                                    @RequestBody Collegue collegue) throws CollegueNonTrouveException, CollegueInvalideException {
       
        if (collegue.getEmail() != null && !collegue.getEmail().isEmpty()) {
            Constantes.COLLEGUE_SERVICE.modifierEmail(matricule, collegue.getEmail());
        }
        
        if (collegue.getPhotoUrl() != null && !collegue.getEmail().isEmpty()) {
            Constantes.COLLEGUE_SERVICE.modifierPhotoUrl(matricule, collegue.getPhotoUrl());
        }
        
        return Constantes.COLLEGUE_SERVICE.rechercheParMatricule(matricule);
    }
}

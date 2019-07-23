package dev.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.Collegue;
import dev.service.CollegueInvalideException;
import dev.service.CollegueLight;
import dev.service.CollegueNonTrouveException;
import dev.service.CollegueService;
import dev.service.CollegueUser;

@CrossOrigin (allowCredentials = "true")
@RestController
@RequestMapping("/collegue")
public class CollegueController {

    @Autowired
    private CollegueService collegueService;

    @RequestMapping(
            method = RequestMethod.GET
            )

    public List<String> recupMatricule(@RequestParam String nom) {

        List<String> matricules = collegueService.chercherParNom(nom)
                .stream()
                .map(c -> c.getMatricule()) // on peut écrire .map(Collegue::getMatricule)
                .collect(Collectors.toList()); // on peut écrire .collect(toList()); en important import static collectors

        return matricules;

    }

    @RequestMapping(
            method = RequestMethod.GET, 
            path = "/{matricule}")

    public Collegue recupCollegueFromMatricule(@PathVariable String matricule) {

        Collegue collegue = collegueService.chercherParMatricule(matricule);
        return collegue;

    }

    @RequestMapping(
            method = RequestMethod.POST
            )

    public Collegue newCollegue(@RequestBody Collegue collegue) {

        Collegue newCollegue = collegueService.ajouterUnCollegue(collegue);

        return newCollegue;

    }
    
    @RequestMapping(
            method = RequestMethod.PATCH,
            path = "/{matricule}"
            )
    
    public Collegue updateCollegue (@PathVariable String matricule,
                                    @RequestBody Collegue collegue) throws CollegueNonTrouveException, CollegueInvalideException {
       
        if (collegue.getEmail() != null && !collegue.getEmail().isEmpty()) {
            collegueService.modifierEmail(matricule, collegue.getEmail());
        }
        
        if (collegue.getPhotoUrl() != null && !collegue.getPhotoUrl().isEmpty()) {
            collegueService.modifierPhotoUrl(matricule, collegue.getPhotoUrl());
        }
        
        return collegueService.chercherParMatricule(matricule);
    }
    
    @RequestMapping(
            method = RequestMethod.GET,
            path = "/galerie"
            )
    
    public List<CollegueLight> getAllColleguesPhotos (){
        List<CollegueLight> collegues = collegueService.lister();
        return collegues;
    }
    
    
    
    @RequestMapping(
            method = RequestMethod.GET, 
            path = "/me")

    public CollegueUser recupCollegueFromEmail() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        CollegueUser collegue = collegueService.chercherParEmail(email);
        return collegue;
    }
    
    
    
    @GetMapping("/admin")
    public String getAdmin() {
      return "ceci est un exemple de GET /admin (role ADMIN)";
    }
 
    @Secured("ROLE_ADMIN")
    @GetMapping("/dba")
    public String getDBA() {
      return "ceci est un exemple de GET /dba (rôle ADMIN)";
    }
    
}

package dev.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
                .map(c -> c.getMatricule())
                .collect(Collectors.toList());
                
        return matricules;
        
    }
    
    
    
}

package dev.service;

public class CollegueNonTrouveException extends RuntimeException {

    
    CollegueNonTrouveException(){
        super("Aucun employé n'est référencé sous ce matricule");
    }
    
}

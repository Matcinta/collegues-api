package dev;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegueRepository extends JpaRepository<Collegue, String> {

    List<Collegue> findByNom(String nom);
    
    Optional<Collegue> findByMatricule(String matricule);
}
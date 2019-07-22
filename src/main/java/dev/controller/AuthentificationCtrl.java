package dev.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.CollegueRepository;
import dev.InfosAuthentification;

@RestController
public class AuthentificationCtrl {
    private CollegueRepository collegueRepository;

    private PasswordEncoder passwordEncoder;

    public AuthentificationCtrl(CollegueRepository collegueRepository, PasswordEncoder passwordEncoder) {
      this.collegueRepository = collegueRepository;
      this.passwordEncoder = passwordEncoder;
    }


    @PostMapping(value = "/me")
    public ResponseEntity<?> authenticate(@RequestBody InfosAuthentification infos) {

      return this.collegueRepository.findByEmail(infos.getEmail())
        .filter(collegue -> passwordEncoder.matches(infos.getMotDePasse(), collegue.getMotDePasse()))
        .map(collegue -> ResponseEntity.ok().build())
        .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());

    }



  }

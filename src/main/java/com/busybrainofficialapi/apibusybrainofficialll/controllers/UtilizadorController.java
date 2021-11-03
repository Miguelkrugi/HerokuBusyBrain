package com.busybrainofficialapi.apibusybrainofficialll.controllers;

import com.busybrainofficialapi.apibusybrainofficialll.models.Utilizador;
import com.busybrainofficialapi.apibusybrainofficialll.models.UtilizadorRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/busybrain/utilizadores")
public class UtilizadorController {
    
    private Logger logger = LoggerFactory.getLogger(UtilizadorController.class); 
    @Autowired
    private UtilizadorRepository utilizadorRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Utilizador> getUnits() {
        logger.info("A Exibir os utilizadores");
        return utilizadorRepository.findAll();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Utilizador saveUtilizador(@RequestBody Utilizador utilizador){

        Utilizador savedUtilizador = (Utilizador) utilizadorRepository.save(utilizador);

        logger.info("Saving the user...");
        return savedUtilizador;


    }

}

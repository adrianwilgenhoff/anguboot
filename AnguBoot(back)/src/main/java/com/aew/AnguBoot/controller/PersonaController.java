/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aew.AnguBoot.controller;

import com.aew.AnguBoot.model.Persona;
import com.aew.AnguBoot.service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Adrian
 */

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/personas"})
public class PersonaController {

    @Autowired
    private PersonaService personaService;
    
    //@RequestMapping(value = "/personas", method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<Persona>> listAllUsers() {

        List<Persona> users = personaService.findAllPersonas();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
    @PostMapping
    public void createUser(@RequestBody Persona user) {

        /*if (personaService.isUserExist(user)) {
            return new ResponseEntity<>("User already exists", HttpStatus.CONFLICT);
        }*/
       personaService.addPersona(user);
               
    }
    
    @GetMapping(path = {"/{id}"})
    public Persona listByID(@PathVariable ("id")int id) {

       return personaService.personaById(id);
    }
    
    @PutMapping(path = {"/{id}"})
    public Persona editPersona(@RequestBody Persona user,@PathVariable("id")int id){
        user.setId(id);
        return personaService.updatePersona(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    //@DeleteMapping((path = {"/{id}"}))
    public void deletePersona(@PathVariable("id")int id){
       personaService.deletePersona(id);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aew.AnguBoot.PersonaServiceImpl;

import com.aew.AnguBoot.model.Persona;
import com.aew.AnguBoot.repo.PersonaRepository;
import com.aew.AnguBoot.service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adrian
 */ 
@Service
public class PersonaServiceImpl implements PersonaService{

    
    @Autowired
    private PersonaRepository personaRepository;
    
    @Override
    public void addPersona(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public void deletePersona(int id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Persona updatePersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public List<Persona> findAllPersonas() {
        return (List<Persona>) personaRepository.findAll();
    }

    @Override
    public Persona personaById(int id) {
        return personaRepository.findById(id);
    }

    
    
}

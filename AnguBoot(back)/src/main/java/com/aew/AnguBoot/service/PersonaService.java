/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aew.AnguBoot.service;

import com.aew.AnguBoot.model.Persona;
import com.aew.AnguBoot.repo.PersonaRepository;
import java.util.List;

/**
 *
 * @author Adrian
 */
public interface PersonaService{
    
    void addPersona (Persona persona);
    
    void deletePersona(int id);

    Persona updatePersona(Persona persona);
    
    List<Persona> findAllPersonas();
    
    Persona personaById(int id);
    
}

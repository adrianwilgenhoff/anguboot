/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aew.AnguBoot.repo;

import com.aew.AnguBoot.model.Persona;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Adrian
 */
@Repository
public interface PersonaRepository extends CrudRepository<Persona, Integer>{
    
    Persona findById(int id);
        
}

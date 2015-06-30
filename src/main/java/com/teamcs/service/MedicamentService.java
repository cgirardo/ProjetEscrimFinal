/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.service;

import com.teamcs.database.bean.Classetherapeutique;
import com.teamcs.database.bean.Medicament;
import java.util.List;

/**
 *
 * @author chris_000
 */
public interface MedicamentService {
    
    void saveMedicament(Medicament medicament);
    
    List<Medicament> findAllMedicament();
    
    void deleteMedicament(Medicament medicament);
    
    Medicament findByName(String name);
    
    void updateMedicament(Medicament medicament);
    
    List<Classetherapeutique> findAllClasses();
}

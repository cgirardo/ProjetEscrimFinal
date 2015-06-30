/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.database.DAO;

import com.teamcs.database.bean.Medicament;
import java.util.List;

/**
 *
 * @author chris_000
 */
public interface MedicamentDAO {
    
    void saveMedicament(Medicament medicament);
    
    List<Medicament> findAllMedicament();
    
    void deleteMedicament(Medicament medicament);
    
    Medicament findByName(String name);
    
    void updateMedicament(Medicament medicament);
}

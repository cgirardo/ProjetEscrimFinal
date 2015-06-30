/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.database.DAO;

import com.teamcs.database.bean.Materiel;
import java.util.List;

/**
 *
 * @author chris_000
 */
public interface MaterielDAO {
    void saveMateriel(Materiel materiel);
    
    List<Materiel> findAllMateriel();
    
    void deleteMateriel(Materiel materiel);
    
    void updateMateriel(Materiel materiel);
}

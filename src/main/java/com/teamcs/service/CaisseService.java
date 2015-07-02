/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.service;

import com.teamcs.database.bean.Caisse;
import java.util.List;

/**
 *
 * @author chris_000
 */
public interface CaisseService {
    
    void saveCaisse(Caisse caisse);
    
    List<Caisse> findAllCaisse();
    
    void deleteCaisseById(int id);
    
    Caisse findById(int id);
    
    void updateCaisse(Caisse caisse);
}

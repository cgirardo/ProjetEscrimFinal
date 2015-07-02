/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.service;

import com.teamcs.database.bean.Aeronef;
import java.util.List;

/**
 *
 * @author chris_000
 */
public interface AeronefService {
    
    void saveAeronef(Aeronef aeronef);
    
    List<Aeronef> findAllAeronef();
    
    void deleteAeronef(Aeronef aeronef);
    
    Aeronef findByName(String name);
    
    void updateAeronef(Aeronef aeronef);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.service.impl;

import com.teamcs.database.DAO.AeronefDAO;
import com.teamcs.database.bean.Aeronef;
import com.teamcs.service.AeronefService;
import java.util.List;

/**
 *
 * @author chris_000
 */
public class AeronefServiceImpl implements AeronefService {
    
    private AeronefDAO dao;

    @Override
    public void saveAeronef(Aeronef aeronef) {
        dao.saveAeronef(aeronef);
    }

    @Override
    public List<Aeronef> findAllAeronef() {
        return dao.findAllAeronef();
    }

    @Override
    public void deleteAeronefByName(String name) {
        dao.deleteAeronefByName(name);
    }

    @Override
    public Aeronef findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public void updateAeronef(Aeronef aeronef) {
        dao.updateAeronef(aeronef);
    }
    
}

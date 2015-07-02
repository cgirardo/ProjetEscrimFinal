/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.service.impl;

import com.teamcs.database.DAO.AeronefDAO;
import com.teamcs.database.DAO.impl.AeronefDAOImpl;
import com.teamcs.database.bean.Aeronef;
import com.teamcs.service.AeronefService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chris_000
 */
public class AeronefServiceImpl implements AeronefService {
    
    private AeronefDAOImpl dao;
    
    public AeronefServiceImpl() {
        dao = new AeronefDAOImpl();
    }
    
    @Override
    public void saveAeronef(Aeronef aeronef) {
        dao.openCurrentSessionwithTransaction();
        dao.saveAeronef(aeronef);
        dao.closeCurrentSessionwithTransaction();
    }

    @Override
    public List<Aeronef> findAllAeronef() {
        List<Aeronef> aeronefs = new ArrayList<Aeronef>();
        dao.openCurrentSessionwithTransaction();
        aeronefs = dao.findAllAeronef();
        dao.closeCurrentSessionwithTransaction();
        return aeronefs;
    }

    @Override
    public void deleteAeronef(Aeronef aeronef) {
        dao.openCurrentSessionwithTransaction();
        dao.deleteAeronef(aeronef);
        dao.closeCurrentSessionwithTransaction();
    }

    @Override
    public Aeronef findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public void updateAeronef(Aeronef aeronef) {
        dao.openCurrentSessionwithTransaction();
        dao.updateAeronef(aeronef);
        dao.closeCurrentSessionwithTransaction();
    }
    
}

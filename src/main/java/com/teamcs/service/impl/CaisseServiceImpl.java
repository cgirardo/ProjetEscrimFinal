/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.service.impl;

import com.teamcs.database.DAO.impl.CaisseDAOImpl;
import com.teamcs.database.bean.Caisse;
import com.teamcs.service.CaisseService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chris_000
 */
public class CaisseServiceImpl implements CaisseService {
    
    private CaisseDAOImpl dao;
    
    public CaisseServiceImpl() {
        dao = new CaisseDAOImpl();
    }
    
    @Override
    public void saveCaisse(Caisse caisse) {
        dao.openCurrentSessionwithTransaction();
        dao.saveCaisse(caisse);
        dao.closeCurrentSessionwithTransaction();
    }

    @Override
    public List<Caisse> findAllCaisse() {
        List<Caisse> caisses = new ArrayList<Caisse>();
        dao.openCurrentSessionwithTransaction();
        caisses = dao.findAllCaisse();
        dao.closeCurrentSessionwithTransaction();
        return caisses;
    }

    @Override
    public void deleteCaisseById(int id) {
        dao.openCurrentSessionwithTransaction();
        dao.deleteCaisseById(id);
        dao.closeCurrentSessionwithTransaction();
    }

    @Override
    public Caisse findById(int id) {
        Caisse caisse = new Caisse();
        dao.openCurrentSessionwithTransaction();
        caisse = dao.findById(id);
        dao.closeCurrentSessionwithTransaction();
        return caisse;
    }

    @Override
    public void updateCaisse(Caisse caisse) {
        dao.openCurrentSessionwithTransaction();
        dao.updateCaisse(caisse);
        dao.closeCurrentSessionwithTransaction();
    }
}

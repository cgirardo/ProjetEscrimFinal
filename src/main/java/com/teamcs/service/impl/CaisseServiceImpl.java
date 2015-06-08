/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.service.impl;

import com.teamcs.database.DAO.CaisseDAO;
import com.teamcs.database.bean.Caisse;
import com.teamcs.service.CaisseService;
import java.util.List;

/**
 *
 * @author chris_000
 */
public class CaisseServiceImpl implements CaisseService {
    
    private CaisseDAO dao;
    
    @Override
    public void saveCaisse(Caisse caisse) {
        dao.saveCaisse(caisse);
    }

    @Override
    public List<Caisse> findAllCaisse() {
        return dao.findAllCaisse();
    }

    @Override
    public void deleteCaisseById(int id) {
        dao.deleteCaisseById(id);
    }

    @Override
    public Caisse findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void updateCaisse(Caisse caisse) {
        dao.updateCaisse(caisse);
    }
}

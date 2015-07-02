/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.service.impl;

import com.teamcs.database.DAO.impl.MaterielDAOImpl;
import com.teamcs.database.bean.Materiel;
import com.teamcs.service.MaterielService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chris_000
 */
public class MaterielServiceImpl implements MaterielService {
    
    private MaterielDAOImpl dao;
    
    public MaterielServiceImpl() {
        dao = new MaterielDAOImpl();
    }
    
    @Override
    public void saveMateriel(Materiel materiel) {
        dao.openCurrentSessionwithTransaction();
        dao.saveMateriel(materiel);
        dao.closeCurrentSessionwithTransaction();
    }

    @Override
    public List<Materiel> findAllMateriel() {
        List<Materiel> medicaments = new ArrayList<Materiel>();
        dao.openCurrentSessionwithTransaction();
        medicaments = dao.findAllMateriel();
        dao.closeCurrentSessionwithTransaction();
        return medicaments;
    }

    @Override
    public void deleteMateriel(Materiel materiel) {
        dao.openCurrentSessionwithTransaction();
        dao.deleteMateriel(materiel);
        dao.closeCurrentSessionwithTransaction();
    }

    @Override
    public void updateMateriel(Materiel materiel) {
        dao.openCurrentSessionwithTransaction();
        dao.updateMateriel(materiel);
        dao.closeCurrentSessionwithTransaction();
    }
    
}

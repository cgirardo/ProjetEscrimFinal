/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.service.impl;

import com.teamcs.database.DAO.impl.MedicamentDAOImpl;
import com.teamcs.database.bean.Medicament;
import com.teamcs.service.MedicamentService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chris_000
 */
public class MedicamentServiceImpl implements MedicamentService {
    
    private MedicamentDAOImpl dao;
    
    public MedicamentServiceImpl() {
        dao = new MedicamentDAOImpl();
    }
    
    @Override
    public void saveMedicament(Medicament medicament) {
        dao.openCurrentSessionwithTransaction();
        dao.saveMedicament(medicament);
        dao.closeCurrentSessionwithTransaction();
    }

    @Override
    public List<Medicament> findAllMedicament() {
        List<Medicament> medicaments = new ArrayList<Medicament>();
        dao.openCurrentSessionwithTransaction();
        medicaments = dao.findAllMedicament();
        dao.closeCurrentSessionwithTransaction();
        return medicaments;
    }

    @Override
    public void deleteMedicamentById(int id) {
        dao.openCurrentSessionwithTransaction();
        dao.deleteMedicamentById(id);
        dao.closeCurrentSessionwithTransaction();
    }

    @Override
    public Medicament findByName(String name) {
        Medicament medoc = new Medicament();
        dao.openCurrentSessionwithTransaction();
        medoc = dao.findByName(name);
        dao.closeCurrentSessionwithTransaction();
        return medoc;
    }

    @Override
    public void updateMedicament(Medicament medicament) {
        dao.openCurrentSessionwithTransaction();
        dao.updateMedicament(medicament);
        dao.closeCurrentSessionwithTransaction();
    }
    
}

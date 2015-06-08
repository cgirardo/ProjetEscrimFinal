/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.service.impl;

import com.teamcs.database.DAO.MedicamentDAO;
import com.teamcs.database.bean.Medicament;
import com.teamcs.service.MedicamentService;
import java.util.List;

/**
 *
 * @author chris_000
 */
public class MedicamentServiceImpl implements MedicamentService {
    
    private MedicamentDAO dao;
    
    @Override
    public void saveMedicament(Medicament medicament) {
        dao.saveMedicament(medicament);
    }

    @Override
    public List<Medicament> findAllMedicament() {
        return dao.findAllMedicament();
    }

    @Override
    public void deleteMedicamentById(int id) {
        dao.deleteMedicamentById(id);
    }

    @Override
    public Medicament findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public void updateMedicament(Medicament medicament) {
        dao.updateMedicament(medicament);
    }
    
}

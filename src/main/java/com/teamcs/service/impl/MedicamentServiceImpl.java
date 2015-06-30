/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.service.impl;

import com.teamcs.database.DAO.impl.ClassetherapeutiqueDAOImpl;
import com.teamcs.database.DAO.impl.MedicamentDAOImpl;
import com.teamcs.database.bean.Classetherapeutique;
import com.teamcs.database.bean.Medicament;
import com.teamcs.service.MedicamentService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chris_000
 */
public class MedicamentServiceImpl implements MedicamentService {
    
    private MedicamentDAOImpl medocDAO;
    private ClassetherapeutiqueDAOImpl classeDAO;
    
    public MedicamentServiceImpl() {
        medocDAO = new MedicamentDAOImpl();
        classeDAO = new ClassetherapeutiqueDAOImpl();
    }
    
    @Override
    public void saveMedicament(Medicament medicament) {
        medocDAO.openCurrentSessionwithTransaction();
        medocDAO.saveMedicament(medicament);
        medocDAO.closeCurrentSessionwithTransaction();
    }

    @Override
    public List<Medicament> findAllMedicament() {
        List<Medicament> medicaments = new ArrayList<Medicament>();
        medocDAO.openCurrentSessionwithTransaction();
        medicaments = medocDAO.findAllMedicament();
        medocDAO.closeCurrentSessionwithTransaction();
        return medicaments;
    }

    @Override
    public void deleteMedicament(Medicament medicament) {
        medocDAO.openCurrentSessionwithTransaction();
        medocDAO.deleteMedicament(medicament);
        medocDAO.closeCurrentSessionwithTransaction();
    }

    @Override
    public Medicament findByName(String name) {
        Medicament medoc = new Medicament();
        medocDAO.openCurrentSessionwithTransaction();
        medoc = medocDAO.findByName(name);
        medocDAO.closeCurrentSessionwithTransaction();
        return medoc;
    }

    @Override
    public void updateMedicament(Medicament medicament) {
        medocDAO.openCurrentSessionwithTransaction();
        medocDAO.updateMedicament(medicament);
        medocDAO.closeCurrentSessionwithTransaction();
    }

    @Override
    public List<Classetherapeutique> findAllClasses() {
        List<Classetherapeutique> classes = new ArrayList<Classetherapeutique>();
        classeDAO.openCurrentSessionwithTransaction();
        classes = classeDAO.findAll();
        classeDAO.closeCurrentSessionwithTransaction();
        return classes;
    }    

    @Override
    public Classetherapeutique findOneClasse(String libelle) {
        Classetherapeutique classe = new Classetherapeutique();
        classeDAO.openCurrentSessionwithTransaction();
        classe = classeDAO.findOne(libelle);
        classeDAO.closeCurrentSessionwithTransaction();
        return classe;
    }
}

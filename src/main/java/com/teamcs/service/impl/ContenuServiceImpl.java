/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.service.impl;

import com.teamcs.database.DAO.impl.ContenuDAOImpl;
import com.teamcs.database.bean.Contenu;
import com.teamcs.service.ContenuService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chris_000
 */
public class ContenuServiceImpl implements ContenuService {
    
    ContenuDAOImpl dao;
    
    public ContenuServiceImpl() {
        dao = new ContenuDAOImpl();
    }
    
    @Override
    public void saveContenu(Contenu contenu) {
        dao.openCurrentSessionwithTransaction();
        dao.saveContenu(contenu);
        dao.closeCurrentSessionwithTransaction();
    }

    @Override
    public List<Contenu> findAllContenu() {
        List<Contenu> medicaments = new ArrayList<Contenu>();
        dao.openCurrentSessionwithTransaction();
        medicaments = dao.findAllContenu();
        dao.closeCurrentSessionwithTransaction();
        return medicaments;
    }

    @Override
    public void deleteContenu(int id) {
        dao.openCurrentSessionwithTransaction();
        dao.deleteContenu(id);
        dao.closeCurrentSessionwithTransaction();
    }

    @Override
    public void updateContenu(Contenu contenu) {
        dao.openCurrentSessionwithTransaction();
        dao.updateContenu(contenu);
        dao.closeCurrentSessionwithTransaction();
    }
}

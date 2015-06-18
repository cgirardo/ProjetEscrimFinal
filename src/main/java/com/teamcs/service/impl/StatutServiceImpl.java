/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.service.impl;

import com.teamcs.database.DAO.StatutDAO;
import com.teamcs.database.DAO.impl.StatutDAOImpl;
import com.teamcs.database.bean.Statut;
import com.teamcs.service.StatutService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chris_000
 */
public class StatutServiceImpl implements StatutService {
    
    private StatutDAOImpl dao;
    
    public StatutServiceImpl() {
        dao = new StatutDAOImpl();
    }
    
    @Override
    public List<Statut> findAll() {
        List<Statut> statuts = new ArrayList<Statut>();
        dao.openCurrentSessionwithTransaction();
        statuts = dao.getAllStatuts();
        dao.closeCurrentSessionwithTransaction();
        return statuts;
    }
    
}

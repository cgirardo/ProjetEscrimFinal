/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.database.DAO.impl;

import com.teamcs.database.DAO.AbstractDAO;
import com.teamcs.database.DAO.ClassetherapeutiqueDAO;
import com.teamcs.database.bean.Classetherapeutique;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;

/**
 *
 * @author chris_000
 */
public class ClassetherapeutiqueDAOImpl extends AbstractDAO implements ClassetherapeutiqueDAO {

    @Override
    public List<Classetherapeutique> findAll() {
        Criteria criteria = getCurrentSession().createCriteria(Classetherapeutique.class);
        return (List<Classetherapeutique>) criteria.list();
    }
    
}

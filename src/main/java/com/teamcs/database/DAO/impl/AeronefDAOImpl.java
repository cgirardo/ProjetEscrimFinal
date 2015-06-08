/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.database.DAO.impl;

import com.teamcs.database.DAO.AbstractDAO;
import com.teamcs.database.DAO.AeronefDAO;
import com.teamcs.database.bean.Aeronef;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author chris_000
 */
public class AeronefDAOImpl extends AbstractDAO implements AeronefDAO {

    @Override
    public void saveAeronef(Aeronef aeronef) {
        persist(aeronef);
    }

    @Override
    public List<Aeronef> findAllAeronef() {
        Criteria criteria = getSession().createCriteria(Aeronef.class);
        return (List<Aeronef>) criteria.list();
    }

    @Override
    public void deleteAeronefByName(String name) {
        Query query = getSession().createSQLQuery("delete from Aeronef where LibelleAeronef = :name");
        query.setString("name", name);
        query.executeUpdate();
    }

    @Override
    public Aeronef findByName(String name) {
        Criteria criteria = getSession().createCriteria(Aeronef.class);
        criteria.add(Restrictions.eq("name", name));
        return (Aeronef) criteria.uniqueResult();
    }

    @Override
    public void updateAeronef(Aeronef aeronef) {
        getSession().update(aeronef);
    }
    
}

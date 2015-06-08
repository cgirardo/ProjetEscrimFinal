/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.database.DAO.impl;

import com.teamcs.database.DAO.AbstractDAO;
import com.teamcs.database.DAO.CaisseDAO;
import com.teamcs.database.bean.Caisse;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author chris_000
 */
public class CaisseDAOImpl extends AbstractDAO implements CaisseDAO {

    @Override
    public void saveCaisse(Caisse caisse) {
        persist(caisse);
    }

    @Override
    public List<Caisse> findAllCaisse() {
        Criteria criteria = getSession().createCriteria(Caisse.class);
        return (List<Caisse>) criteria.list();
    }

    @Override
    public void deleteCaisseById(int id) {
        Query query = getSession().createSQLQuery("delete from Caisse where IdCaisse = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @Override
    public Caisse findById(int id) {
        Criteria criteria = getSession().createCriteria(Caisse.class);
        criteria.add(Restrictions.eq("id", id));
        return (Caisse) criteria.uniqueResult();
    }

    @Override
    public void updateCaisse(Caisse caisse) {
        getSession().update(caisse);
    }
}

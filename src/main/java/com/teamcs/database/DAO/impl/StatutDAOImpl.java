/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.database.DAO.impl;

import com.teamcs.database.DAO.AbstractDAO;
import com.teamcs.database.DAO.StatutDAO;
import com.teamcs.database.bean.Statut;
import com.teamcs.database.bean.Utilisateur;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author chris_000
 */
public class StatutDAOImpl extends AbstractDAO implements StatutDAO {

    @Override
    public List<Statut> getAllStatuts() {
        Criteria criteria = getCurrentSession().createCriteria(Statut.class);
        return (List<Statut>) criteria.list();
    }

    @Override
    public Statut getStatutByName(String statut) {
        Criteria criteria = getCurrentSession().createCriteria(Statut.class);
        criteria.add(Restrictions.eq("libelleStatut", statut));
        return (Statut)criteria.uniqueResult();
    }
}

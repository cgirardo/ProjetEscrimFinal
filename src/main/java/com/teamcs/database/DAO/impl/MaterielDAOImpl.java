/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.database.DAO.impl;

import com.teamcs.database.DAO.AbstractDAO;
import com.teamcs.database.DAO.MaterielDAO;
import com.teamcs.database.bean.Materiel;
import java.util.List;
import org.hibernate.Criteria;

/**
 *
 * @author chris_000
 */
public class MaterielDAOImpl extends AbstractDAO implements MaterielDAO {

    @Override
    public void saveMateriel(Materiel materiel) {
        getCurrentSession().persist(materiel);
    }

    @Override
    public List<Materiel> findAllMateriel() {
        Criteria criteria = getCurrentSession().createCriteria(Materiel.class);
        return (List<Materiel>) criteria.list();
    }

    @Override
    public void deleteMateriel(Materiel materiel) {
        getCurrentSession().delete(materiel);
    }

    @Override
    public void updateMateriel(Materiel materiel) {
        getCurrentSession().update(materiel);
    }
}

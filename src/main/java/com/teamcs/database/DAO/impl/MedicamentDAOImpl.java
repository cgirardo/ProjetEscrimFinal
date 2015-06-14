/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.database.DAO.impl;

import com.teamcs.database.DAO.AbstractDAO;
import com.teamcs.database.DAO.MedicamentDAO;
import com.teamcs.database.bean.Medicament;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author chris_000
 */
public class MedicamentDAOImpl extends AbstractDAO implements MedicamentDAO {

    @Override
    public void saveMedicament(Medicament medicament) {
        getCurrentSession().persist(medicament);
    }

    @Override
    public List<Medicament> findAllMedicament() {
        Criteria criteria = getCurrentSession().createCriteria(Medicament.class);
        return (List<Medicament>) criteria.list();
    }

    @Override
    public void deleteMedicamentById(int id) {
        Query query = getCurrentSession().createSQLQuery("delete from Medicament where IdMedicament = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @Override
    public Medicament findByName(String name) {
        Criteria criteria = getCurrentSession().createCriteria(Medicament.class);
        criteria.add(Restrictions.eq("LibelleMedicament", name));
        return (Medicament) criteria.uniqueResult();
    }

    @Override
    public void updateMedicament(Medicament medicament) {
        getCurrentSession().update(medicament);
    }
    
}

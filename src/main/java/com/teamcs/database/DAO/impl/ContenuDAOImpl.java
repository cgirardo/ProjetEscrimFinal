/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.database.DAO.impl;

import com.teamcs.database.DAO.AbstractDAO;
import com.teamcs.database.DAO.ContenuDAO;
import com.teamcs.database.bean.Contenu;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author chris_000
 */
public class ContenuDAOImpl extends AbstractDAO implements ContenuDAO {

    @Override
    public void saveContenu(Contenu contenu) {
        getCurrentSession().persist(contenu);
    }

    @Override
    public List<Contenu> findAllContenu() {
        Criteria criteria = getCurrentSession().createCriteria(Contenu.class);
        return (List<Contenu>) criteria.list();
    }

    @Override
    public void deleteContenu(int id) {
        Query query = getCurrentSession().createQuery("delete from Contenu where idContenu = :id");
        query.setInteger("idContenu", id);
        query.executeUpdate();
        
    }

    @Override
    public void updateContenu(Contenu contenu) {
        getCurrentSession().update(contenu);
    }
}

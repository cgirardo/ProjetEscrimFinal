/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.database.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author chris_000
 */
public abstract class AbstractDAO {
    
    private SessionFactory sessionFactory;
    
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    public void persist(Object entity) {
        getSession().persist(entity);
    }
    
    public void delete(Object entity) {
        getSession().delete(entity);
    }
}

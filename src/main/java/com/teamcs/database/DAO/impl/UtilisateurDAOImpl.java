/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.database.DAO.impl;

import com.teamcs.database.DAO.AbstractDAO;
import com.teamcs.database.DAO.UtilisateurDAO;
import com.teamcs.database.bean.Utilisateur;
import org.hibernate.Query;

/**
 *
 * @author chris_000
 */
public class UtilisateurDAOImpl extends AbstractDAO implements UtilisateurDAO {

    @Override
    public void saveUtilisateur(Utilisateur utilisateur) {
        persist(utilisateur);
    }

    @Override
    public void updateUtilisateur(Utilisateur utilisateur) {
        getSession().update(utilisateur);
    }

    @Override
    public Utilisateur findByLogin(String login) {
        Query query = getSession().createSQLQuery("from Utilisateur where Login = :login");
        query.setString("login", login);
        return (Utilisateur) query.uniqueResult();
    }
    
}

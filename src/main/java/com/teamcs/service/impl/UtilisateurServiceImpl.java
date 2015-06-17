/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.service.impl;

import com.teamcs.database.DAO.impl.UtilisateurDAOImpl;
import com.teamcs.database.bean.Utilisateur;
import com.teamcs.exceptions.UtilisateurException;
import com.teamcs.service.UtilisateurService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chris_000
 */
public class UtilisateurServiceImpl implements UtilisateurService {

    private UtilisateurDAOImpl dao;
    
    public UtilisateurServiceImpl() {
        dao = new UtilisateurDAOImpl();
    }
    
    @Override
    public void saveUtilisateur(Utilisateur utilisateur) {
        dao.openCurrentSessionwithTransaction();
        dao.saveUtilisateur(utilisateur);
        dao.closeCurrentSessionwithTransaction();
    }

    @Override
    public void updateUtilisateur(Utilisateur utilisateur) {
        dao.openCurrentSessionwithTransaction();
        dao.updateUtilisateur(utilisateur);
        dao.closeCurrentSessionwithTransaction();
    }                

    @Override
    public String connectUtilisateur(String login, String password) throws UtilisateurException {
        dao.openCurrentSession();
        Utilisateur user = dao.findByLogin(login);
        if(user != null) {
            if(user.getMotDePasse().equals(password)) {
                dao.closeCurrentSession();
                return user.getStatut().getLibelleStatut();
            } else {
                throw new UtilisateurException("Mot de passe erroné");
            }
        } else {
            throw new UtilisateurException("Utilisateur inconnu");
        }
    }

    @Override
    public List<Utilisateur> findAll() {
        List<Utilisateur> users = new ArrayList<Utilisateur>();
        dao.openCurrentSessionwithTransaction();
        users = dao.findAllUtilisateur();
        dao.closeCurrentSessionwithTransaction();
        return users;
    }
}
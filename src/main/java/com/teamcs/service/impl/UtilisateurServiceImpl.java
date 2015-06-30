/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.service.impl;

import com.teamcs.database.DAO.impl.StatutDAOImpl;
import com.teamcs.database.DAO.impl.UtilisateurDAOImpl;
import com.teamcs.database.bean.Statut;
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

    private UtilisateurDAOImpl userDAO;
    private StatutDAOImpl statutDAO;
    
    public UtilisateurServiceImpl() {
        userDAO = new UtilisateurDAOImpl();
        statutDAO = new StatutDAOImpl();
    }
    
    @Override
    public void saveUtilisateur(Utilisateur utilisateur) {
        userDAO.openCurrentSessionwithTransaction();
        userDAO.saveUtilisateur(utilisateur);
        userDAO.closeCurrentSessionwithTransaction();
    }

    @Override
    public void updateUtilisateur(Utilisateur utilisateur) {
        userDAO.openCurrentSessionwithTransaction();
        userDAO.updateUtilisateur(utilisateur);
        userDAO.closeCurrentSessionwithTransaction();
    }                

    @Override
    public String connectUtilisateur(String login, String password) throws UtilisateurException {
        userDAO.openCurrentSession();
        Utilisateur user = userDAO.findByLogin(login);
        if(user != null) {
            if(user.getMotDePasse().equals(password)) {
                userDAO.closeCurrentSession();
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
        userDAO.openCurrentSessionwithTransaction();
        users = userDAO.findAllUtilisateur();
        userDAO.closeCurrentSessionwithTransaction();
        return users;
    }

    @Override
    public void deleteUtilisateur(Utilisateur utilisateur) {
        userDAO.openCurrentSessionwithTransaction();
        userDAO.deleteUtilisateur(utilisateur);
        userDAO.closeCurrentSessionwithTransaction();
    }

    @Override
    public List<Statut> findAllStatuts() {
        List<Statut> statuts = new ArrayList<Statut>();
        statutDAO.openCurrentSessionwithTransaction();
        statuts = statutDAO.getAllStatuts();
        statutDAO.closeCurrentSessionwithTransaction();
        return statuts;
    }
    
    @Override
    public Statut findOneStatutByLibelle(String libelle) {
        Statut statut = new Statut();
        statutDAO.openCurrentSessionwithTransaction();
        statut = statutDAO.getStatutByName(libelle);
        statutDAO.closeCurrentSessionwithTransaction();
        return statut;
    }
}
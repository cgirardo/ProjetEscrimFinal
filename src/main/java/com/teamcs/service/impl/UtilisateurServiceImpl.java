/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.service.impl;

import com.teamcs.database.DAO.UtilisateurDAO;
import com.teamcs.database.bean.Utilisateur;
import com.teamcs.service.UtilisateurService;

/**
 *
 * @author chris_000
 */
public class UtilisateurServiceImpl implements UtilisateurService {

    private UtilisateurDAO dao;
    
    @Override
    public void saveUtilisateur(Utilisateur utilisateur) {
        dao.saveUtilisateur(utilisateur);
    }

    @Override
    public void updateUtilisateur(Utilisateur utilisateur) {
        dao.updateUtilisateur(utilisateur);
    }                
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.service;

import com.teamcs.database.bean.Utilisateur;

/**
 *
 * @author chris_000
 */
public interface UtilisateurService {
    
    void saveUtilisateur(Utilisateur utilisateur);
    
    void updateUtilisateur(Utilisateur utilisateur);
}

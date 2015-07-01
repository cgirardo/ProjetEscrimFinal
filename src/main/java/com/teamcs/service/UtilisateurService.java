/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.service;

import com.teamcs.database.bean.Statut;
import com.teamcs.database.bean.Utilisateur;
import com.teamcs.exceptions.UtilisateurException;
import java.util.List;

/**
 *
 * @author chris_000
 */
public interface UtilisateurService {
    
    void saveUtilisateur(Utilisateur utilisateur);
    
    String connectUtilisateur(String login, String password) throws UtilisateurException;
    
    List<Utilisateur> findAll();
    
    void updateUtilisateur(Utilisateur utilisateur);
    
    void deleteUtilisateur(Utilisateur utilisateur);
    
    List<Statut> findAllStatuts();
    
    Statut findOneStatutByLibelle(String libelle);
}

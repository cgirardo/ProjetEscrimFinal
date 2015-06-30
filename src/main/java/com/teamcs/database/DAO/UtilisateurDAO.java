/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.database.DAO;

import com.teamcs.database.bean.Statut;
import com.teamcs.database.bean.Utilisateur;
import java.util.List;

/**
 *
 * @author chris_000
 */
public interface UtilisateurDAO {
    
    void saveUtilisateur(Utilisateur utilisateur);
    
    Utilisateur findByLogin(String login);
    
    List<Utilisateur> findAllUtilisateur();
    
    void updateUtilisateur(Utilisateur utilisateur);   
    
    void deleteUtilisateur(Utilisateur utilisateur);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.service;

import com.teamcs.database.bean.Contenu;
import java.util.List;

/**
 *
 * @author chris_000
 */
public interface ContenuService {
    void saveContenu(Contenu contenu);
    
    List<Contenu> findAllContenu();
    
    void deleteContenu(int id);
    
    void updateContenu(Contenu contenu);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.database.DAO;

import com.teamcs.database.bean.Caisse;
import java.sql.Connection;

/**
 *
 * @author chris_000
 */
public class CaisseDAO extends DAO<Caisse> {
    
    public CaisseDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Caisse obj) {
        return false;
    }

    @Override
    public boolean delete(Caisse obj) {
        return false;
    }

    @Override
    public boolean update(Caisse obj) {
        return false;
    }

    @Override
    public Caisse find(int id) {
        return false;
    }
}

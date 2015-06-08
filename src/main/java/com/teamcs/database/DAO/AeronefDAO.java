/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.database.DAO;

import com.teamcs.database.bean.Aeronef;
import java.sql.Connection;

/**
 *
 * @author chris_000
 */
public class AeronefDAO extends DAO<Aeronef> {
    
    public AeronefDAO(Connection conn) {
        super(conn);
    }
    
    @Override
    public boolean create(Aeronef obj) {
        return false;
    }

    @Override
    public boolean delete(Aeronef obj) {
        return false;
    }

    @Override
    public boolean update(Aeronef obj) {
        return false;
    }

    @Override
    public Aeronef find(int id) {
        return false;
    }
    
}

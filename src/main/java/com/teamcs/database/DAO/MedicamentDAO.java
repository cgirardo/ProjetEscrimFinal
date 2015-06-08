/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.database.DAO;

import com.teamcs.database.bean.Medicament;
import java.sql.Connection;

/**
 *
 * @author chris_000
 */
public class MedicamentDAO extends DAO<Medicament> {
    
    public MedicamentDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Medicament obj) {
        return false;
    }

    @Override
    public boolean delete(Medicament obj) {
        return false;
    }

    @Override
    public boolean update(Medicament obj) {
        return false;
    }

    @Override
    public Medicament find(int id) {
        return false;
    }
}

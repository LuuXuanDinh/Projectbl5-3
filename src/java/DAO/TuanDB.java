/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import context.BaseDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Tuan;

/**
 *
 * @author XuanDinh
 */
public class TuanDB extends BaseDAO {

    public  ArrayList<Tuan> tuans() {
        ArrayList<Tuan> tuans = new ArrayList<>();
        xSql = "select * from Tuan";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int id;
            String KhoangTG;
            Tuan x;
            while (rs.next()) {
                id = rs.getInt(1);
                KhoangTG = rs.getString(2);
                x = new Tuan(id, KhoangTG);
                tuans.add(x);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
        }
        return tuans;
    }

    public Tuan getTuan(int id) {
        for (Tuan t : tuans()) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }
}


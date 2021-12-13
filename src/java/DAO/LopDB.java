/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import context.BaseDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Lop;

/**
 *
 * @author XuanDinh
 */
public class LopDB extends BaseDAO {

    public ArrayList<Lop> lops() {
        ArrayList<Lop> lops = new ArrayList<>();
        xSql = "select * from Lop";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int id;
            String ten;
            Lop x;
            while (rs.next()) {
                id = rs.getInt(1);
                ten = rs.getString(2);
                x = new Lop(id, ten);
                lops.add(x);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
        }
        return lops;
    }

    public Lop getLop(int id) {
        for (Lop l : lops()) {
            if (l.getId() == id) {
                return l;
            }
        }
        return null;
    }
}

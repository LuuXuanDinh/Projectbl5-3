/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import context.BaseDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Slot;

/**
 *
 * @author XuanDinh
 */
public class SlotDB extends BaseDAO {

    public ArrayList<Slot> slots() {
        ArrayList<Slot> slots = new ArrayList<>();
        xSql = "select * from Slot";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int id;
            String KhungTG;
            Slot x;
            while (rs.next()) {
                id = rs.getInt(1);
                KhungTG = rs.getString(2);
                x = new Slot(id, KhungTG);
                slots.add(x);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
        }
        return slots;
    }

    public Slot getSlot(int id) {
        for (Slot s : slots()) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
}

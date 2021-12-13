/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import context.BaseDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.HocSinh;
import model.Ngay;
import model.Slot;

/**
 *
 * @author XuanDinh
 */
public class AttendingDB extends BaseDAO {

    public void setAttending(ArrayList<HocSinh> hocsinhs, ArrayList<HocSinh> hocsinhsAttend, Ngay ngay, Slot slot) {
        for (HocSinh h : hocsinhs) {
            if (hocsinhsAttend.contains(h)) {
                xSql = "Insert into Attend(mssv,ngay,slotId) Values(?,?,?)";
                try {
                    ps = con.prepareStatement(xSql);
                    ps.setString(1, h.getMssv());
                    ps.setDate(2, ngay.getNgay());
                    ps.setInt(3, slot.getId());
                    ps.executeUpdate();
                    System.out.println("Done!");
                    ps.close();
                } catch (SQLException e) {
                    System.out.println("Loi");
                }
            } else {
                xSql = "Delete Attend where mssv = ? and ngay = ? and slotId = ?";
                try {
                    ps = con.prepareStatement(xSql);
                    ps.setString(1, h.getMssv());
                    ps.setDate(2, ngay.getNgay());
                    ps.setInt(3, slot.getId());
                    ps.executeUpdate();
                    System.out.println("Done!");
                    ps.close();
                } catch (SQLException e) {
                    System.out.println("Loi");
                }
            }
        }
    }
}

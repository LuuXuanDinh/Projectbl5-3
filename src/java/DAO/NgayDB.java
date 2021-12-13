/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import context.BaseDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Ngay;
import model.Tuan;

/**
 *
 * @author XuanDinh
 */
public class NgayDB extends BaseDAO {

    public ArrayList<Ngay> ngays() {
        ArrayList<Ngay> ngays = new ArrayList<>();
        xSql = "select * from Ngay";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            TuanDB tdb = new TuanDB();
            Date ngay;
            Tuan tuan;
            Ngay x;
            while (rs.next()) {
                ngay = rs.getDate(1);
                tuan = tdb.getTuan(rs.getInt(2));
                x = new Ngay(ngay, tuan);
                ngays.add(x);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
        }
        return ngays;
    }

    public ArrayList<Ngay> ngayTrongTuan(int tuanId) {
        ArrayList<Ngay> ngays = new ArrayList<>();
        xSql = "select * from Ngay where tuan = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, tuanId);
            rs = ps.executeQuery();
            TuanDB tdb = new TuanDB();
            Date ngay;
            Tuan tuan;
            Ngay x;
            while (rs.next()) {
                ngay = rs.getDate(1);
                tuan = tdb.getTuan(rs.getInt(2));
                x = new Ngay(ngay, tuan);
                ngays.add(x);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
        }
        return ngays;
    }

    public Ngay getNgay(Date ngay) {
        for (Ngay n : ngays()) {
            if (n.getNgay().equals(ngay)) {
                return n;
            }
        }
        return null;
    }
}

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
import model.Lop;

/**
 *
 * @author XuanDinh
 */
public class HocSinhDB extends BaseDAO {

    public ArrayList<HocSinh> hocsinhs() {
        ArrayList<HocSinh> hocsinhs = new ArrayList<>();
        xSql = "select * from HocSinh";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String mssv, ten;
            Boolean gioi;
            Lop lop;
            HocSinh x;
            LopDB ldb = new LopDB();
            while (rs.next()) {
                mssv = rs.getString(1);
                ten = rs.getString(2);
                gioi = rs.getBoolean(3);
                lop = ldb.getLop(rs.getInt(4));
                x = new HocSinh(mssv, ten, gioi, lop);
                hocsinhs.add(x);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
        }
        return hocsinhs;
    }

    public HocSinh getHocsinh(String mssv) {
        for (HocSinh h : hocsinhs()) {
            if (h.getMssv().equals(mssv)) {
                return h;
            }
        }
        return null;
    }

    public ArrayList<HocSinh> hocsinhLop(int id) {
        ArrayList<HocSinh> hocsinhs = new ArrayList<>();
        for (HocSinh hs : hocsinhs()) {
            if(hs.getLop().getId()==id) hocsinhs.add(hs);
        }
        return hocsinhs;
    }
}

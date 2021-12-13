/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import context.BaseDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.LichHoc;
import model.Lop;
import model.Ngay;
import model.Slot;

/**
 *
 * @author XuanDinh
 */
public class LichHocDB extends BaseDAO {

    public ArrayList<LichHoc> lichhoc() {
        ArrayList<LichHoc> lichhocs = new ArrayList<>();
        xSql = "select * from LichHoc";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            NgayDB ndb = new NgayDB();
            SlotDB sdb = new SlotDB();
            LopDB ldb = new LopDB();
            Ngay ngay;
            Slot slot;
            Lop lop;
            LichHoc x;
            while (rs.next()) {
                ngay = ndb.getNgay(rs.getDate(1));
                slot = sdb.getSlot(rs.getInt(2));
                lop = ldb.getLop(rs.getInt(3));
                x = new LichHoc(ngay, lop, slot);
                lichhocs.add(x);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
        }
        return lichhocs;
    }

    public ArrayList<Lop> lops(Ngay ngay, Slot slot) {
        ArrayList<Lop> lops = new ArrayList<>();
        System.out.println(ngay.getNgay() + "+++" + slot.getKhungTG());
        for (LichHoc lh : lichhoc()) {
            if (lh.getNgay().getNgay().equals(ngay.getNgay()) && lh.getSlot().getId() == slot.getId()) {
                lops.add(lh.getLop());
                System.out.println(lh.getNgay());
            }
        }
        return lops;
    }
}

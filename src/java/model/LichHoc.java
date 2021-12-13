/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author XuanDinh
 */
public class LichHoc {

    private Ngay ngay;
    private Lop lop;
    private Slot slot;

    public LichHoc() {
    }

    public LichHoc(Ngay ngay, Lop lop, Slot slot) {
        this.ngay = ngay;
        this.lop = lop;
        this.slot = slot;
    }

    public Ngay getNgay() {
        return ngay;
    }

    public void setNgay(Ngay ngay) {
        this.ngay = ngay;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

}


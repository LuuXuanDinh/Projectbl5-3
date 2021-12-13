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
public class Attending {

    private HocSinh hocsinh;
    private Ngay ngay;
    private Slot slot;

    public Attending() {
    }

    public Attending(HocSinh hocsinh, Ngay ngay, Slot slot) {
        this.hocsinh = hocsinh;
        this.ngay = ngay;
        this.slot = slot;
    }

    public HocSinh getHocsinh() {
        return hocsinh;
    }

    public void setHocsinh(HocSinh hocsinh) {
        this.hocsinh = hocsinh;
    }

    public Ngay getNgay() {
        return ngay;
    }

    public void setNgay(Ngay ngay) {
        this.ngay = ngay;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

}


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
public class HocSinh {

    private String mssv;
    private String ten;
    private boolean gioi;
    private Lop lop;

    public HocSinh() {
    }

    public HocSinh(String mssv, String ten, boolean gioi, Lop lop) {
        this.mssv = mssv;
        this.ten = ten;
        this.gioi = gioi;
        this.lop = lop;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public boolean isGioi() {
        return gioi;
    }

    public void setGioi(boolean gioi) {
        this.gioi = gioi;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author XuanDinh
 */
public class Ngay {

    private Date ngay;
    private Tuan tuan;

    public Ngay() {
    }

    public Ngay(Date ngay, Tuan tuan) {
        this.ngay = ngay;
        this.tuan = tuan;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public Tuan getTuan() {
        return tuan;
    }

    public void setTuan(Tuan tuan) {
        this.tuan = tuan;
    }

}

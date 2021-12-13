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
public class Tuan {

    private int id;
    private String KhoangTG;

    public Tuan() {
    }

    public Tuan(int id, String KhoangTG) {
        this.id = id;
        this.KhoangTG = KhoangTG;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKhoangTG() {
        return KhoangTG;
    }

    public void setKhoangTG(String KhoangTG) {
        this.KhoangTG = KhoangTG;
    }

}

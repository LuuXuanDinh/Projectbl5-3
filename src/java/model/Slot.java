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
public class Slot {

    private int id;
    private String KhungTG;

    public Slot() {
    }

    public Slot(int id, String KhungTG) {
        this.id = id;
        this.KhungTG = KhungTG;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKhungTG() {
        return KhungTG;
    }

    public void setKhungTG(String KhungTG) {
        this.KhungTG = KhungTG;
    }

}

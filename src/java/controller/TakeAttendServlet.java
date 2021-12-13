/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.LichHocDB;
import DAO.LopDB;
import DAO.NgayDB;
import DAO.SlotDB;
import DAO.TuanDB;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Ngay;
import model.Slot;
import model.Tuan;

/**
 *
 * @author XuanDinh
 */
public class TakeAttendServlet extends HttpServlet {



    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       TuanDB tdb = new TuanDB();
        NgayDB ndb = new NgayDB();
        SlotDB sdb = new SlotDB();
        LopDB ldb = new LopDB();
        LichHocDB lhdb = new LichHocDB();
        ArrayList<Slot> slots = sdb.slots();
        ArrayList<Tuan> tuans = tdb.tuans();
        ArrayList<Ngay> ngays = ndb.ngayTrongTuan(1);
        request.getSession().setAttribute("tuans", tuans);
        request.getSession().setAttribute("tuan", tdb.getTuan(1));
        request.getSession().setAttribute("ngays", ngays);
        request.getSession().setAttribute("ngay", ngays.get(0));
        request.getSession().setAttribute("slots", slots);
        request.getSession().setAttribute("slot", slots.get(0));
        request.getSession().setAttribute("lops", lhdb.lops(ngays.get(0), slots.get(0)));
        request.getRequestDispatcher("attending.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TuanDB tdb = new TuanDB();
        NgayDB ndb = new NgayDB();
        SlotDB sdb = new SlotDB();
        LopDB ldb = new LopDB();
        LichHocDB lhdb = new LichHocDB();
        Ngay ngay;
        Slot slot = null;
        if (request.getParameter("tuan") != null) {
            int id = Integer.parseInt(request.getParameter("tuan"));
            Tuan tuan = tdb.getTuan(id);
            ArrayList<Ngay> ngays = ndb.ngayTrongTuan(id);
            request.getSession().setAttribute("tuan", tuan);
            request.getSession().setAttribute("ngays", ngays);
        }
        if (request.getParameter("ngay") != null) {
            ngay = ndb.getNgay(Date.valueOf(request.getParameter("ngay")));
            request.getSession().setAttribute("ngay", ngay);
        } else {
            ArrayList<Ngay> ngays = (ArrayList<Ngay>) request.getSession().getAttribute("ngays");
            ngay = ngays.get(0);
            request.getSession().setAttribute("ngay", ngay);
        }
        if (request.getParameter("slot") != null) {
            slot = sdb.getSlot(Integer.parseInt(request.getParameter("slot")));
            request.getSession().setAttribute("slot", slot);
        }else{
            slot = (Slot) request.getSession().getAttribute("slot");
        }
        request.getSession().setAttribute("lops", lhdb.lops(ngay, slot));
        request.getRequestDispatcher("attending.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

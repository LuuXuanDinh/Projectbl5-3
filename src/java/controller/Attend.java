/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.AttendingDB;
import DAO.HocSinhDB;
import DAO.LopDB;
import DAO.NgayDB;
import DAO.SlotDB;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.HocSinh;
import model.Ngay;
import model.Slot;

/**
 *
 * @author XuanDinh
 */
public class Attend extends HttpServlet {



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
       NgayDB ndb = new NgayDB();
        SlotDB sdb = new SlotDB();
        LopDB ldb = new LopDB();
        HocSinhDB hdb = new HocSinhDB();
        int id = Integer.parseInt(request.getParameter("Lop"));
        request.getSession().setAttribute("lop", ldb.getLop(id));
        ArrayList<HocSinh> hocsinhs = hdb.hocsinhLop(id);
        request.getSession().setAttribute("hocsinhs", hocsinhs);
        request.getRequestDispatcher("class.jsp").forward(request, response);
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
         ArrayList<HocSinh> hocsinhs = (ArrayList<HocSinh>) request.getSession().getAttribute("hocsinhs");
        ArrayList<HocSinh> hocsinhsAttend = new ArrayList<>();
        for (HocSinh h : hocsinhs) {
            if (request.getParameter(h.getMssv()) != null) {
                hocsinhsAttend.add(h);
            }
        }
        AttendingDB adb = new AttendingDB();
        adb.setAttending(hocsinhs, hocsinhsAttend, (Ngay) request.getSession().getAttribute("ngay"), (Slot) request.getSession().getAttribute("slot"));
        request.getRequestDispatcher("takeattend").forward(request, response);
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

<%-- 
    Document   : attending
    Created on : Dec 12, 2021, 10:49:48 PM
    Author     : XuanDinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Ngay"%>
<%@page import="model.Tuan"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Điểm danh</title>
    </head>
    <body>
        <form action="takeattend" method="post">
            Tuần: 
            <select name="tuan" onchange="this.form.submit()">
                <option value="${sessionScope.tuan.getId()}">${sessionScope.tuan.getKhoangTG()}</option>
                <c:forEach var="t" items="${sessionScope.tuans}">
                    <c:if test="${t.getId() != sessionScope.tuan.getId()}">
                        <option value="${t.getId()}">${t.getKhoangTG()}</option>
                    </c:if>
                </c:forEach>
            </select>
        </form>
        <form action="takeattend" method="post">
            Ngày: 
            <select name="ngay" onchange="this.form.submit()">
                <option value="${sessionScope.ngay.getNgay()}">${sessionScope.ngay.getNgay()}</option>
                <c:forEach var="n" items="${sessionScope.ngays}">
                    <c:if test="${n.getNgay() != sessionScope.ngay.getNgay()}">
                        <option value="${n.getNgay()}">${n.getNgay()}</option>
                    </c:if>
                </c:forEach>
            </select>
        </form>
        <form action="takeattend" method="post">
            Slot: 
            <select name="slot" onchange="this.form.submit()">
                <option value="${sessionScope.slot.getId()}">${sessionScope.slot.getKhungTG()}</option>
                <c:forEach var="s" items="${sessionScope.slots}">
                    <c:if test="${s.getId() != sessionScope.slot.getId()}">
                        <option value="${s.getId()}">${s.getKhungTG()}</option>
                    </c:if>
                </c:forEach>
            </select>
        </form>
        <c:if test="${sessionScope.lops!=null}">
            <c:forEach var="l" items="${sessionScope.lops}">
                <h2>${l.getTen()}<a type="button" href="Attend?Lop=${l.getId()}">Take</a></h2>
            </c:forEach>
        </c:if>
    </body>
</html>

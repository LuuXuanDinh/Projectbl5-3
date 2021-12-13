<%-- 
    Document   : class
    Created on : Dec 12, 2021, 10:51:39 PM
    Author     : XuanDinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${sessionScope.lop.getTen()}</h1>
        <form action="Attend" method="post">
            <table>
                <colgroup>
                    <col width="150" span="1">
                    <col width="750" span="1">
                    <col width="500" span="1">
                    <col width="200" span="1">
                </colgroup>
                <tr>
                    <th>MSSV</th>
                    <th>Tên</th>
                    <th>Giới Tính</th>
                    <th>Attend</th>
                </tr>
                <c:forEach var="h" items="${sessionScope.hocsinhs}">
                    <colgroup>
                        <col width="150" span="1">
                        <col width="500" span="1">
                        <col width="250" span="1">
                        <col width="200" span="1">
                    </colgroup>
                    <tr>
                        <td>${h.getMssv()}</td>
                        <td>${h.getTen()}</td>
                        <td>${h.isGioi()?"Nam":"Nữ"}</td>
                        <td><input type="checkbox" name="${h.getMssv()}"/></td>
                    </tr>
                </c:forEach>
            </table>
            <button type="submit" >Lưu</button>
        </form>
    </body>
</html>

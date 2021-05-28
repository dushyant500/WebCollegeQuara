<%-- 
    Document   : home
    Created on : 17 Mar, 2021, 5:20:36 PM
    Author     : Dushyant
                           @@  FACULTY HOME  @@
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.CollegeQuara.dao.UserDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../blocks/header.jsp" %>
<%@include file="../blocks/facultymenu.jsp" %>

<html>
    <%
       
       UserDao usedao = new UserDao();
       ArrayList<User> students = usedao.listStudents(branch);
    
    %>
<div class="tm-right-column">
    <div class="tm-content-div">
        
        <h1 class='text-danger bg-info'>Welcome Faculty</h1>
        <hr>
        
        <table class="table table-bordered" class="align-middle" >
            <tr>
                <th> Student Name </th>
                <th> Student Email </th>
            </tr>
             <% for(User stud : students)  { %>
            <tr>
            
            <td><%=stud.getUserName()%></td>
            <td><%=stud.getEmail()%></td>
            
            </tr>
            <% } %>
        </table>
        
        
        
    </div>
</div>    
<%@include file="../blocks/footer.jsp" %>
<%-- 
    Document   : home
    Created on : 17 Mar, 2021, 5:21:14 PM
    Author     : Dushyant
                            @@ STUDENT HOME..JSP @@
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.CollegeQuara.dao.UserDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../blocks/header.jsp" %>
<%@include file="../blocks/studentmenu.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student@Home</title>
    <%
       
       int id = user.getUserid();
       UserDao usedao = new UserDao();
       ArrayList<User> students = usedao.list(branch,id);
    
    %>
    </head>
    <body>
        
        <div class="tm-right-column">
             <div class="tm-content-div">
        
        <h1 class='text-danger bg-info'>Welcome student</h1>
        <hr>

        <table class="table table-bordered" class="align-middle" >
            <tr>
                <th> Your BatchMate's Name </th>
                <th>  Email </th>
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

    </body>
</html>

<%@include file="../blocks/footer.jsp" %>

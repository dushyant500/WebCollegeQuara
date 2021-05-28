<%-- 
    Document   : viewquestion
    Created on : 12 Apr, 2021, 12:51:51 PM
    Author     : Dushyant
--%>
<%@page import="java.util.List"%>
<%@page import="com.CollegeQuara.dao.QuestionDao"%>
<%@page import="com.CollegeQuara.dto.Question"%>
<%@page import="com.CollegeQuara.dao.AnswerDao"%>
<%@page import="com.CollegeQuara.dto.Answer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../blocks/header.jsp" %>
<%@include file="../blocks/studentmenu.jsp" %>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
 </head>
   <%
       Answer a = new Answer();
       AnswerDao ad = new AnswerDao();
       QuestionDao qd = new QuestionDao();
       int id  = Integer.parseInt(request.getParameter("qus"));
       
       Question qus = qd.get(id);
       List<Answer> lis = ad.listByQuestion(id);
   %>
    <div class="tm-right-column">
             <div class="tm-content-div">
                 <h1 class='text-danger bg-info'>View Answer</h1>
        <hr>
        <h3>Qus : <%=qus.getQus()%></h3>    
        
        <table class='table'>
            <tr>
                <th>Faculty Name</th>
                <th>Date</th>
                <th>Answer</th>
            </tr>
            <% for(Answer ans : lis) { %>
            <tr>
                <td><%=ans.getFacultyName()%></td>                
                <td><%=ans.getAnsDate()%></td>
                <th><%=ans.getAns()%></th>               
                
            </tr>
            <% } %>
        </table>

             </div>
    </div>
<%@include file="../blocks/footer.jsp" %>
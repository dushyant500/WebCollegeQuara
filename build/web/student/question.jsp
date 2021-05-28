<%-- 
    Document   : question
    Created on : 27 Mar, 2021, 11:58:03 AM
    Author     : Dushyant
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../blocks/header.jsp" %>
<%@include file="../blocks/studentmenu.jsp" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.CollegeQuara.dto.Question"%>
<%@page import="java.util.List"%>
<%@page import="com.CollegeQuara.dao.QuestionDao"%>
<%
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    QuestionDao qDao = new QuestionDao();
    List<Question> qList = qDao.listByStudent(user.getUserid());
%>

<!DOCTYPE html><head>
                 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                 <title>Question</title>
               </head>
    <body> 
         <div class="tm-right-column">
             <div class="tm-content-div">
               <hr>
                 
               <form action="<%=path%>/askqus" method="post">
                   
                   <textarea name="ques" cols="45" rows="6" placeholder="Ask Question" ></textarea>
                     <br><br>
                     <button class="btn-outline-primary" type="submit">Send Question</button>
                 
               </form>
              
                <hr>
                <table class="table table-hover">
                    <tr>
                        <th>Question</th>
                        <th>Ask Date</th>
                        <th>Answers</th>
                    </tr>
            <% for (Question qu : qList ) { %>
            <tr>
                <td><%=qu.getQus()%></td>
                <td><%=sdf.format(qu.getAskDate())%></td>
                <td>
                    <a href='<%=path%>/student/viewanswer.jsp?qus=<%=qu.getQid()%>'>View Answer</a>    
                </td>
            </tr>
            <% } %>
                    
                    
                </table>
                
             </div>
         </div>
    </body>

<%@include file="../blocks/footer.jsp" %>

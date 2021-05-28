<%-- 
    Document   : studquestion
    Created on : 27 Mar, 2021, 12:30:04 PM
    Author     : Dushyant
--%>

<%@page import="com.CollegeQuara.dao.QuestionDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.CollegeQuara.dto.Question"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../blocks/header.jsp" %>
<%@include file="../blocks/facultymenu.jsp" %>
<%
     
     SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
     
     QuestionDao qdao = new QuestionDao();
     List<Question> lis =qdao.list(branch);
     
%>
<script>
    function send(evt,ob,qid)
    {
        var txt = ob.value;
        var code = evt.keyCode;
        
  
      if (code===13)
        {
           console.log("script on enter code");
            var url = "<%=path%>/faculty/sendans";
            var dat = {ans:txt,quesid:qid};
                   
            console.log(url,dat);        
           $.post(url,dat,function(data,status)
            {
                //console.log("...IN post ...... ",data);
                alert(data);
                ob.value='';
            });
            
        }
        
    }
    
</script>
<!DOCTYPE html>

    
             <div class="tm-right-column">
                <div class="tm-content-div">
                    <title> GiveQuestion </title>
                     <h1 class="text-success">Hello Faculty Give Answer!!</h1>
       <table class='table'>
            <tr>
                <th>Student Name</th>
                <th>Question</th>
                <th>Ask Date</th>               
            </tr>
           
            <% for (Question q : lis) { %>
            <tr>
                <th><%=q.getName()%></th>
                <td><%=q.getQus()%></td>
                <td><%=sdf.format(q.getAskDate())%></td>                
            </tr> 
            <tr>
                <td></td>
                <td colspan="2">
                    <textarea value="" onkeyup="send(event,this,<%=q.getQid()%>)">
                        
                    </textarea>
                    
                </td>
            </tr>
               <% } %> 
       </table>         
                </div>
             </div>
    
<%@include file="../blocks/footer.jsp" %>
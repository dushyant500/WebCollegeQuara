<%-- 
    Document   : login
    Created on : 11 Mar, 2021, 4:11:20 PM
    Author     : Dushyant
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String msg = "";

    String regData = request.getParameter("err");
    if(regData!=null)
    {
        msg = "Invalid User !";
    }
%>

<%@include file="blocks/header.jsp" %>
<%@include file="blocks/menu.jsp" %>


<div class="tm-right-column">
    <div class="tm-content-div">
        
        <h1 class='text-danger bg-info'>User Login</h1>
        <hr>
        <form action="Login" method="post">
        
        <div class="row form-group">            
            
            <div class='col-lg-12'>
                <input type="email" class='form-control' placeholder="Your Email"
                       name='email' required>
            </div>
        </div>
        
        <div class='row form-group'>
            <div class='col-lg-12'>
                <input type="password" class='form-control' placeholder="Password"
                       name='pass' required>
            </div>            
        </div>
        
           <div class='row form-group'>
               <div class='col-lg-6'>
                   <button  type='submit' class='btn btn-success'>Login</button>                                          
               </div>
               <div class='col-lg-6'>
                    <b class='text-danger'><%=msg%></b>     
               </div>
           </div>
        </form>
<%@include file="blocks/footer.jsp" %>
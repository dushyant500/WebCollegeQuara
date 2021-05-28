<%-- 
    Document   : register
    Created on : 11 Mar, 2021, 4:24:01 PM
    Author     : Dushyant
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="blocks/header.jsp" %>
<%@include file="blocks/menu.jsp" %>
<%
    String msg = "";

    String regData = request.getParameter("flag");
    if(regData!=null)
    {
        msg = "password not match";
    }
%>



<div class="tm-right-column">
    <div class="tm-content-div">
        
        <h1 class='text-danger bg-info'>User Registration</h1>
        <hr>
        <form action="register" method="post">
        
        <div class="row form-group">            
            <div class='col-lg-6'>
                <input type="text" class='form-control' placeholder="Your Name"
                       name='username' required>
            </div>
            <div class='col-lg-6'>
                <input type="email" class='form-control' placeholder="Your Email"
                       name='email' required>
            </div>
        </div>
        
        <div class='row form-group'>
            <div class='col-lg-6'>
                <input type="password" class='form-control' placeholder="Password"
                       name='pass' required>
            </div>
            <div class='col-lg-6'>
                <input type="password" class='form-control' placeholder="Confirm Password"
                       name="cpass"  required>
            </div>            
        </div>
        
        <div class='row form-group'>
            <div class='col-lg-6'>
                <select name='branch' class='form-control' required>
                    <option value=''>Choose Branch</option>
                    <option value='cs'>Computer Science</option>
                    <option value='me'>Mechanical</option>
                    <option value='ce'>Civil</option>
                </select>
            </div>
            <div class='col-lg-6'>
                <select name='type' class='form-control' required>
                    <option value=''>Choose Type</option>
                    <option value='student'>Student</option>
                    <option value='faculty'>Faculty</option>                    
                </select>
            </div>
        </div>
        
           <div class='row form-group'>
            
                 <div class='col-lg-6'>
                   <button  type='submit' 
                           class='btn btn-success'>Verify</button>                                          
                 </div>
                                <div class='col-lg-6'>
                    <b class='text-danger'><%=msg%></b>     
               </div>
       
            
           </div>
        </form>
<%@include file="blocks/footer.jsp" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="blocks/header.jsp" %>
<%@include file="blocks/menu.jsp" %>
<%
    String msg= "";
    
    Object err = request.getAttribute("err");
    if(err!=null){
        msg = "Verification Failed !";
    }
%>


<div class="tm-right-column">
    <div class="tm-content-div">
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Verificaton Page</title>
        </head>
    <body>
            <h1 class="text-danger bg-primary">User Verfication</h1>
            <form action="verify" method="post">
                <div class="row form-group">  
                  <div class="col-lg-6">
                    <input type="email" class="form-control" placeholder="Your verificaton Email"
                           name="email" required>
                  </div>
                  <div class="col-lg-6">
                    <input type="password" class="form-control" placeholder="verfication OTP"
                           name="otp" required>              
                  </div>
                </div>
                <div class="row form-group">
                   <div class='col-lg-6'>
                       <button type='submit' 
                           class='btn btn-success'>Verify User</button>                                          
                   </div>
                   
                    <div class='col-lg-6'>
                           <b class='text-danger'><%=msg%></b>     
                   </div>
                
                </div>
           </form>
        
        
        </body>
    </div>
</div>    
<%@include file="blocks/footer.jsp" %>
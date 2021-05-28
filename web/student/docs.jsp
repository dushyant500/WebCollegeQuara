<%@page import="com.CollegeQuara.dto.Docs"%>
<%@page import="java.util.List"%>
<%@page import="com.CollegeQuara.dao.UserDao"%>
<%@include file="../blocks/header.jsp" %>
<%@include file="../blocks/studentmenu.jsp" %>

<%
    UserDao udao = new UserDao();
    
    List<Docs> list = udao.listDocs(branch);

%>

<div class="tm-right-column">
    <div class="tm-content-div">
        
        <h1 class='text-danger bg-info'>View Documents</h1>
        <hr>
        
        <table class='table table-hovered'>
            <tr>
                <th>Faculty</th>
                <th>Date</th>
                <th>Download</th>
            </tr>
            
            <% for(Docs obj : list) { %>
            <tr>
                <th><%=obj.getFacName()%></th>
                <td><%=obj.getUploadDate()%></td>
                <th>
                    <a target="_blank" href='<%=path%>/assets/docs/<%=obj.getFacid()%>/<%=obj.getFileName()%>'>
                        <b>Download</b>
                    </a>
                </th>
                
                
            </tr>
            <% } %>
        </table>
    </div>
</div>    
<%@include file="../blocks/footer.jsp" %>
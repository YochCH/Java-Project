<%-- 
    Document   : WelcomePatient
    Created on : 08/07/2021, 00:04:00
    Author     : user
--%>

<%@page import="clinic.*"%>
<%@page import="users.*"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
            Patient patient = (Patient)request.getServletContext().getAttribute("user");
        %>
        <h1>Welcome patient <%=patient.getName()%></h1>
        
        <form action="Action">
            
            <input type="submit" value="createReport" name="action"/>                    
        </form>
    </body>
</html>

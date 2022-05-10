<%-- 
    Document   : Index
    Created on : 06/07/2021, 19:35:30
    Author     : huser
--%>

<%@page import="businesslogic.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <% 
        ClinicNameSession CN=new ClinicNameSession(); 
        String clinicName=CN.getClinicName();
    %>
    <body>
       
        <h3><%=clinicName%></h3>
        <h1>Clinic</h1>
        <form action="Login" method="post">  
  
            Name:<input type="text" name="userName"/><br/><br/>  
            Password:<input type="password" name="userPass"/><br/><br/>              

            <input type="submit" value="היכנס"/>  

        </form>  
    </body>
</html>

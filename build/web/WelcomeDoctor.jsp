<%-- 
    Document   : WelcomeDoctor
    Created on : 08/07/2021, 00:02:54
    Author     : user
--%>

<%@page import="users.Doctor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Doctor doctor = (Doctor)request.getServletContext().getAttribute("user");
        %>
        <h1>Welcome Dr <%=doctor.getName()%>!</h1>
        <form action="Action">
            <h2>Add Patient:</h2>
            <input type="text" placeholder="Name" name="addName"/><br/>
            <input type="text" placeholder="Password" name="addPassword"/><br/>
            <input type="submit" name="action" value="addPatient"/>            
            <br/><br/>
            <input type="submit" name="action" value="createReport" placeHolder="createReport" />
            
            <h2>Add Treatment:</h2>
            <input placeholder="Date" name="addDate" type="datetime"/><br/>
            <input placeholer = "Tooth Number" name="addToothNumber" type = "number"/><br/>
            <select name="addTreatmentType">
                <option value="FILLING">FILLING</option>
                <option value="ROOT_CANAL">ROOT_CANAL</option>
            </select><br/>
            <input type="number" placeholder="Price" name="addPrice"/><br/>
            <input type="checkbox" name="addPaid"/><label>Paid</label><br/>
            <label/>Patient ID<label>
            <input type="text" name="addPatientId"/>
            <input type="submit" name="action" value="addTreatment"/>
            <br/><br/>
            <h2>Set Treatment:</h2>
            <input type="number" placeholder="Id Treatment" name="id"/><br/>
            <input placeholder="Date" name="setDate" type="datetime"/><br/>
            <input placeholer = "Tooth Number" name="setToothNumber" type = "number"/><br/>
            <select name="setTreatmentType">
                <option value="FILLING">FILLING</option>
                <option value="ROOT_CANAL">ROOT_CANAL</option>
            </select><br/>
            <input type="number" placeholder="setPrice" name="setPrice"/><br/>
            <input type="checkbox" name="setPaid"/><label>Paid</label><br/>
            <input type="submit" name="action" value="setTreatment"/>
            <br/><br/>
        </form>
    </body>
</html>

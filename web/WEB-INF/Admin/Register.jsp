<%-- 
    Document   : Register
    Created on : Feb 2, 2023, 3:04:21 PM
    Author     : jvavi
    Page to set up the creation of a new user
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix = "fn"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register Page</title>
  </head>
  <body>
    <h1 class="PageTitle">Add employees</h1>

    <p style="text-align: center">In this page, you will create an account for a new employee.</p>

    <h1 style="text-align: center">Create an account for an employee</h1>
    
    <form name="Registration" action="RegistrationMade" method="GET" class="Category">

      ID: <input type="text" name="Identity" />

        Username: <input type="text" name="Name" />

        Password: <input type="text" name="Passing Word" />

        <input type="submit" value="Add Regular Employee"/>
        
        </form> <br> <hr> <br> <br> 

      <h1 style="text-align: center">Create an account for a special employee</h1>
        
        <form name="Registration" action="SRegistrationMade" method="GET" class="Category">

      ID: <input type="text" name="Identity" />

        Username: <input type="text" name="Name" />

        Password: <input type="text" name="Passing Word" />

        <input type="submit" value="Add Special Employee"/>
        
        </form> <br> <hr> <br> <br> 

      <form name= "AdmPage" action="AdminPage" method="POST">
        
      <input type="submit" value="Admin Page" class="Category">
        
    </form> <br> <hr> <br> <br>

    <img src="Images/NewEmp.png" class="Images" alt="Sorry, no image found"/> <br> <br> <br>
    
  </body>
  
</html>

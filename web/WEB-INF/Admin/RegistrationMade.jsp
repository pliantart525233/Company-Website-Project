<%-- 
    Document   : RegistrationMade
    Created on : Feb 6, 2023, 3:22:27 PM
    Author     : jvavi
    Page shown after the user succesfully create a new user
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix = "fn"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Regular Registration</title>
  </head>
  <body>
    <h1 class="PageTitle"> User Successfully Created</h1>
    <h2 style="text-align:center  ">New User Created! The ID is ${MyID}, the Username is ${MyUser} and the password is ${MyPassword}</h2>
    <form name= "AdmPage" action="AdminPage" method="POST" class="Category">
        
      <input type="submit" value="Admin Page">
        
    </form> <br> <br> <br> <br>
    <img src="Images/SomethingWorked.gif" class="Images" alt="Sorry, no image found"/> <br> <br> <br>
  </body>
</html>

<%-- 
    Document   : LoginPage
    Created on : Feb 14, 2023, 1:05:37 PM
    Author     : jvavi
    In this page, employees with regular permissions will put their user information to log in into their account
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix = "fn"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
  </head>
  <body>
    <h1 class="PageTitle">Login Info</h1>
    Insert your account information
    <form name="AddForm" action="Login" method="GET">
      

    ID: <input type="text" name="Identity" />

      <br>

        Username: <input type="text" name="username" />
      
        <br>

        Password: <input type="password" name="password" />

        <br> <br>

        <input type="submit" value="login"/>
        
        <br><br>
        
        </form>

    <p>If your can't log in into your account, please email jvavila2007@gmail.com</p>

    <form name="ToIndex" action="index.jsp" method="POST">
            
      <input type="submit" value="Go Back"/> </form>

      <img src="Images/LetMeIn.png" class="Images" alt="Sorry, no image found"/> <br> <br> <br>
    
  </body>

</html>

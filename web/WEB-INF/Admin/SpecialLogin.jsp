<%-- 
    Document   : Login
    Created on : Feb 9, 2023, 9:54:28 PM
    Author     : jvavi
    Page that the user will go if they succesfully logged in
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Successful</title>
  </head>
  <body>
    <h1 class="PageTitle">Thank you for login in to the account ${MyUser}</h1>

    <p class="Category">Please click the button below</p>

    <br> <br>
    
    <form name= "AdmPage" action="AdminPage" method="POST" class="Category">
        
      <input type="submit" value="Admin Page">
        
    </form> </body> 
    
</html>

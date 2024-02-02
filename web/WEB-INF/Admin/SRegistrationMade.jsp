<%-- 
    Document   : SRegistrationMade
    Created on : Mar 22, 2023, 2:06:34 PM
    Author     : jvavi
    Page to create more accounts for employees with special powers
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Special Registration</title>
  </head>
  <body>
    <h1 class="PageTitle"> User Successfully Created</h1>
    <h2 style="text-align:center  ">New User Created! The ID is ${MyID}, the Username is ${MyUser} and the password is ${MyPassword}</h2>
    <form name= "AdmPage" action="AdminPage" method="POST" class="Category">
        
      <input type="submit" value="Admin Page">
        
    </form> <br> <br> <br> <br>
  </body>
</html>

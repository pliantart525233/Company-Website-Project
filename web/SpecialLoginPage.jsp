<%-- 
    Document   : SpecialLoginPage
    Created on : Mar 20, 2023, 3:10:06 PM
    Author     : jvavi
    In this page, employees with special permissions will put their user information to log in into their account
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Administrator Login Page</title>
  </head>
  <body>
  <h1 class="PageTitle">Login Info</h1>
    Insert your account information
    <form name="AddForm" action="SpecialLogin" method="GET">
      

    ID: <input type="text" name="Identity" />

      <br>

        Username: <input type="text" name="username" />
      
        <br>

        Password: <input type="password" name="password" />

        <br> <br>

        <input type="submit" value="login"/>
        
        <br><br>
        
        </form>
        
        <br> 

        <form name="ToIndex" action="index.jsp" method="POST">
            
      <input type="submit" value="Go Back"/> </form>

  </body>

</html>

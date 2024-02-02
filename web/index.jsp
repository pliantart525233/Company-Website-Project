<%-- 
    Document   : index
    Created on : Feb 27, 2023, 2:12:15 PM
    Author     : jvavi
    This is the website's main page
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
    <title>Main Page</title>
  </head>
  <body>
    <h1 class="PageTitle"> Wallow Official Website for Staff Members</h1>
    
    <p class="TemQueCentralizar">Hello, and welcome to Wallow's official website for employees. If you are not am employee, please, do not attempt to login in one of our workers account</p> 
    
    <p class="TemQueCentralizar"> Now that we (hopefully) only have an employee reading this, welcome to the team (older employees probably don't read this anyway). We are happy to have you.</p>
    <p class="TemQueCentralizar">Please login into your account.</p>
    <p class="TemQueCentralizar">WARNING: Trying to log in using your account in the wrong login option will not work</p> 
    
    <br>
    
    <form name="Login" action="LoginPage" method="GET">
        
      <input type="submit" value="Login as a regular staff" class="Category">
        
    </form><br> 
    
    <form name="SLogin" action="SpecialLoginPage" method="POST">
        
      <input type="submit" value="Login as an administrator" class="Category">
        
    </form><br> <br>
    
    <!--
    
    <form name= "MyDB" action="dbPage" method="POST">
        
      <input type="submit" value="Show Food">
        
    </form>
    
    -->

  </body>

</html>

<%-- 
    Document   : RegularPage
    Created on : Mar 22, 2023, 2:26:16 PM
    Author     : jvavi
    Main page for the employees
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee Page</title>
  </head>
  <body>
    <h1 class="PageTitle">Employees Page</h1>

    <div id="center">
    
    <p class="Category">This is the main page for employees. You will use this page to check how many units of a product we have, as well as their prices.</p>

    <br> <p class="Category">To see all of that information, please click the button below.</p> </div> <br>
    
    <form name= "AdmPage" action="Items" method="POST">
        
      <input type="submit" value="Show Products" class="Category"> </form> <br> 

    <form name="ToIndex" action="index.jsp" method="POST" >
            
      <input type="submit" value="Go Back to the Main Page" class="Category"/>  </form>
    
  </body>
</html>

<%-- 
    Document   : EmployeeRemoved
    Created on : Mar 24, 2023, 3:13:54 PM
    Author     : jvavi
    Page after an employee is succesfully removed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee Removed</title>
  </head>
  <body>
    <h1 class="PageTitle">Employee Succesfully Removed!</h1>
    
    <p class="Category"> The employee ID provided (${MyUser}) provided was successfully removed </p> <br><br>
    
    <form name="GoBack" action="AdminPage" method="POST">
        
      <input type="submit" value="Admin Page" class="Category">
        
    </form>
        
    </form>

    
  </body>
</html>

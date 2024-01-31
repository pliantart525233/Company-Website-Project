
<%-- 
    Document   : EmployeeRemoval
    Created on : Mar 24, 2023, 3:04:16 PM
    Author     : jvavi
    Page for the removal of an employee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

  <head>

    <link rel="stylesheet" type="text/css" href="style.css" />

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Remove Employee</title>
  
  </head>

  <body>

    <h1 class="PageTitle">Employee Removal</h1>
    
    <p style="text-align: center">This is the page that you will use to remove an employee (please, only use this page if requested).</p>
    <p style="text-align: center">Observation: It is impossible to remove an employee with special permissions using this page</p>
    
    <form name="Remove Item" action="EmployeeRemoved" method="GET" class="Category">
      
    Employee ID: <input type="text" name="Identification" />
    
    <input type="submit" value="Remove Employee">
    
    </form> <br> <hr> <br> <br> 

    <form name= "AdmPage" action="AdminPage" method="POST">
        
      <input type="submit" value="Admin Page" class="Category">
        
    </form>
    
  </body>

</html>

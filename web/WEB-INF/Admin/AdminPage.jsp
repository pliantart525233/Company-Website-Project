<%-- 
    Document   : AdminPage
    Created on : Mar 22, 2023, 1:24:24 PM
    Author     : jvavi
    Main Page for admins
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin Page</title>
  </head>
  <body>

    <h1 class="PageTitle">Admin Page</h1>
    
    <p class="TemQueCentralizar"> Hello. This is the main page for the employees that are allowed to change the company's information (administrators).
  </p>
    <p class="TemQueCentralizar">If you have access to this page, you will need to make changes into the information of our company. </p>
    <p class="TemQueCentralizar"> That can be an account information, or a product information. </p>
    <p class="SpecialColor">Please, only change things when requested.</p> <br>


    
    <form name= "MyDB" action="dbPage" method="POST">
        
      <input type="submit" value="Show Website Information" class="Category">
        
    </form> <br> 

    <form name="AddItems" action="AddItem" method="POST">
        
      <input type="submit" value="Add Product" class="Category">
        
    </form> <br>
    
    <form name="AddPeople" action="Register" method="POST">
        
      <input type="submit" value="Create Employee Account" class="Category">
        
    </form> <br>
    
    <form name="DeleteAnItem" action="DeleteItem" method="POST">
        
      <input type="submit" value="Delete a Product" class="Category">
        
    </form> <br>
    
    <form name="DeleteEmployee" action="EmployeeRemoval" method="POST">
        
      <input type="submit" value="Remove Employee" class="Category">
        
    </form> <br>
    
    <form name="UpgradeStuff" action="ItemUpdating" method="POST">
        
      <input type="submit" value="Update Products information" class="Category">
        
    </form> <br>

    <form name="ToIndex" action="index.jsp" method="POST">
            
      <input type="submit" value="Go Back to the Main Page" class="Category"/> </form>

  </body>

</html>

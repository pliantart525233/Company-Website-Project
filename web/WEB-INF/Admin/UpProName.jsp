<%-- 
    Document   : UpProName
    Created on : Mar 31, 2023, 1:19:08 PM
    Author     : jvavi
    Page after the change of the name of a product
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Update Name</title>
  </head>
  <body>
    <h1 class="PageTitle">Update Successful</h1> <br>
    <h1 class="Category">Values from ${AuthUsed} updated</h1> <br>
    
    <form name= "AdmPage" action="AdminPage" method="POST">
        
      <input type="submit" value="Admin Page" class="Category">
        
    </form> </div>
  </body>
</html>

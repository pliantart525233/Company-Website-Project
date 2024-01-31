<%-- 
    Document   : ItemDeleted
    Created on : Mar 24, 2023, 2:22:38 PM
    Author     : jvavi
    Page after the deletion of a product
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Product Deleted</title>
  </head>
  <body>
    <h1 class="PageTitle">Product Successfully Deleted!</h1>

    <p class="Category"> The product provided was successfully removed </p>
    
    <form name="Back" action="AdminPage" method="POST">
        
      <input type="submit" value="Admin Page" class="Category">
        
    </form>
    
  </body>
</html>

<%-- 
    Document   : DeleteItem
    Created on : Mar 24, 2023, 2:12:47 PM
    Author     : jvavi
    Page for the deletion of a product
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Product Deletion</title>
  </head>
  <body>
    <h1 class="PageTitle">Remove Product</h1>

    <div id="center"> 
    
    <p class="TemQueCentralizar">In case that there is a product that we no longer sell, come to this page, and delete the product.</p>

    </div> <br>
    
    
    <form name="Remove Item" action="ItemDeleted" method="GET" class="Category">

    Authentication Number: <input type="text" name="AuthNumb" />
    
    <input type="submit" value="Delete Item" >
    
    </form> <br> <hr> <br> <br> 

    <form name= "AdmPage" action="AdminPage" method="POST">
        
      <input type="submit" value="Admin Page"class="Category">
        
    </form>
    
  </body>
</html>

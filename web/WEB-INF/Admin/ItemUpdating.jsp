<%-- 
    Document   : ItemUpdating
    Created on : Mar 31, 2023, 1:15:10 PM
    Author     : jvavi
    Update the information about products
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Products Update</title>
  </head>
  <body>

  <h1 class="PageTitle">Update Products</h1>

  <p class="Category">In this page, you will modify any information about a product that you were requested to change.</p> <br><br>
    
    <form name="UpName" action="UpProName" method="GET" class="Category">
      
      Authentication Number: <input type="text" name="AuthNumb" />
      
      New Name: <input type="text" name="NewName" />
        
      <input type="submit" value="Update Product Name">
        
    </form> <br> <hr> <br> <br> 
    
    <form name="UpPrice" action="UpProPrice" method="GET" class="Category">
      
      Authentication Number: <input type="text" name="AuthNumb" />
      
      New Price: <input type="text" name="NewPrice" />
        
      <input type="submit" value="Update Product Price">
        
    </form> <br> <hr> <br> <br> 
    
    <form name="UpQuantity" action="UpProQuantity" method="GET" class="Category"> 
      
      Authentication Number: <input type="text" name="AuthNumb" />
      
      New Quantity: <input type="text" name="CQuantity" />
        
      <input type="submit" value="Update Product Quantity">
        
    </form> <br> <hr> <br> <br> 
    
    <form name="UpAll" action="UpAll" method="GET" class="Category">
      
      Authentication Number: <input type="text" name="AuthNumb" />
      
      New Name: <input type="text" name="NewName" />
      
      New Price: <input type="text" name="NewPrice" />
      
      New Quantity: <input type="text" name="CQuantity" />
        
      <input type="submit" value="Update Everything">
        
    </form> <br> <hr> <br> <br> 
    <form name= "AdmPage" action="AdminPage" method="POST">
        
      <input type="submit" value="Admin Page" class="Category">
        
    </form> <br> <hr> <br> <br> 
  </body>
</html>

<%-- 
    Document   : Register
    Created on : Feb 2, 2023, 2:23:33 PM
    Author     : jvavi
    Page for the addition of a new product
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix = "fn"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Adding Product</title>
  </head>
  <body>
    <h1 class="PageTitle">Add Product</h1>

    <div id="center"> 
    
    <p style="text-align: center"> In this page, you will be able to add any product. Please, only add items that were requested.</p>

    <p style="text-align: center"> Remember to insert the correct item name, price and the remaining stock</p>

    <div>
    
    <form name="AddAnItem" action="ItemAdded" method="GET" class="Category">

        Name: <input type="text" name="Name" />

        Price: <input type="text" name="Price" />

        Quantity: <input type="text" name="Quantity" />

        <input type="submit" value="Add Product"/>
        
        </form> <br> <hr> <br> <br> 

        <form name= "AdmPage" action="AdminPage" method="POST">
        
      <input type="submit" value="Admin Page" class="Category">
        
    </form>
        
  </body>
  
</html>

<%-- 
    Document   : RegistrationMade
    Created on : Feb 9, 2023, 2:21:02 PM
    Author     : jvavi
    Page after a product is succesfully added
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix = "fn"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Product Added</title>
  </head>
  <body>
  <h1 class="PageTitle">Product Successfully Added</h1> <br> <br><br>
    <h1 class="Category">New product added! The product Name is ${MyItem}, the price is $${MyPrice} and there are ${MyQuantity} of it left</h1>
    <br> <br><form name= "AdmPage" action="AdminPage" method="POST">
        
      <input type="submit" value="Admin Page" class="Category">
        
    </form>
  </body>
</html>

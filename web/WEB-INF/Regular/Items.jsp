<%-- 
    Document   : Items
    Created on : Mar 22, 2023, 2:20:32 PM
    Author     : jvavi
    Page where employees will be able to see the information about products
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix = "fn"%>

<%@page errorPage="Error.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Products information Page</title>
  </head>
  <body>
  <h1 class="PageTitle"> Products Page </h1>
    <p class="TemQueCentralizar">These are the items that we currently have, as well as their price and remaining stock. Please, use this page to sell our products to our customers</p>
    
    <br><br>
    
    <table border ="3" width = "50%"  class="Category"
           style="text-align : center; color: purple">
      <tr>
        <th>Item Name</th>
        <th>Price</th>
        <th>Quantity Remaining</th>
      </tr>
      <c:forEach var = "row" items = "${data}">
        <tr>
          <td><c:out value = "${row.get(1)}"/></td>
          <td><c:out value = "${row.get(2)}"/></td>
          <td><c:out value = "${row.get(3)}"/></td>
        </tr>
      </c:forEach>
    </table>

    <br><br><br><br>
        
    <form name= "AdmPage" action="NormalEmpPage" method="POST" >
        
      <input type="submit" value="Go Back" class="Category"> </form> <br><br><br>

      <img src="Images/DontRemember.jpeg" class="Images" alt="Sorry, no image found"/>
    
  </body>
</html>

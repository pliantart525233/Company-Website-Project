<%-- 
    Document   : dbPage
    Created on : Jan 31, 2023, 2:10:51 PM
    Author     : jvavi
    Page that the databases will appear, so the admins can change information
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
    <title>Database Page</title>
  </head>
  <body>
    <h1 class="PageTitle">Database Information</h1>

    <br><br><div id="center"> 

    <p class="TemQueCentralizar"> This page contains all the information of our companies information. <br> It contains the products and the different users accounts </p>
<br><br>
    <h1 class="TemQueCentralizar"> Product Information </h1>
    <table border ="3" width = "50%" class="Category"
           style="text-align : center; color: purple">
      <tr>
        <th>Authentication Number</th>
        <th>Item Name</th>
        <th>Price</th>
        <th>Quantity Remaining</th>
      </tr>
      <c:forEach var = "row" items = "${data}">
        <tr>
          <td><c:out value = "${row.get(0)}"/></td>
          <td><c:out value = "${row.get(1)}"/></td>
          <td><c:out value = "${row.get(2)}"/></td>
          <td><c:out value = "${row.get(3)}"/></td>
        </tr>
      </c:forEach>
    </table>

    <br><br><br>
    
    <h1 class="TemQueCentralizar"> Administrators </h1>

    <table border ="3"
        width = "50%" class="Category" style="text-align : center; color: purple">
      <tr>
        <th>Staff ID</th>
        <th>UserName</th>
        <th>PassWord</th>
      </tr>
      <c:forEach var = "row" items = "${data2}">
        <tr>
          <td><c:out value = "${row.get(0)}"/></td>
          <td><c:out value = "${row.get(1)}"/></td>
          <td><c:out value = "${row.get(2)}"/></td>
        </tr>
      </c:forEach></table>
        
        <br><br><br>
        
        <h1 class="TemQueCentralizar"> Regular Staff </h1>
        
        <table border ="3" width = "50%" class="Category"
           style="text-align : center; color: purple">
      <tr>
        <th>Staff ID</th>
        <th>UserName</th>
        <th>PassWord</th>
      </tr>
      <c:forEach var = "row" items = "${data3}">
        <tr>
          <td><c:out value = "${row.get(0)}"/></td>
          <td><c:out value = "${row.get(1)}"/></td>
          <td><c:out value = "${row.get(2)}"/></td>
        </tr>
      </c:forEach></table>
        <div>
<br><br>
        <form name= "AdmPage" action="AdminPage" method="POST">
        
      <input type="submit" value="Admin Page" class="Category">
        
    </form> <br> <br>
    
  </body>
</html>

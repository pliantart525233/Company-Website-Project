<%-- 
    Document   : UpAll
    Created on : Mar 31, 2023, 1:19:55 PM
    Author     : jvavi
    Page after the change of all the information (except authentication number) of a product
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Update All</title>
  </head>
  <body>
    <h1 class="PageTitle">Update Successful</h1> <br>
    <h1 class="Category">Values from ${AuthUsed} updated</h1> <br>
    
    <form name= "AdmPage" action="AdminPage" method="POST" >
        
      <input type="submit" value="Admin Page" class="Category">
        
    </form> </div>
  </body>
</html>
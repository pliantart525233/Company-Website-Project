/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

 /*
 * João Vítor Chaves Avila, Spring to Summer of 2023
 * Control how, when and more of the flow between webpages
 */

import java.sql.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author jvavi
 */  // Set the availble URLs
@WebServlet(name = "Controller", loadOnStartup = 1, urlPatterns = {
    "/destination",
    "/calculation",
    "/dbPage",
    "/LoginPage",
    "/Redirect",
    "/Hidden",
    "/Register",
    "/RegistrationMade",
    "/Login",
    "/ItemAdded",
    "/AddItem",
    "/SpecialLoginPage",
    "/SpecialLogin",
    "/AdminPage",
    "/SRegistrationMade",
    "/Items",
    "/NormalEmpPage",
    "/DeleteItem",
    "/ItemDeleted",
    "/EmployeeRemoval",
    "/EmployeeRemoved",
    "/ItemUpdating",
    "/UpProName",
    "/UpProPrice",
    "/UpProQuantity",
    "/UpAll"
    
})
public class Controller extends HttpServlet {
  
  //Create an object of the JavaDatabase file
  JavaDatabase UseDatabase = new JavaDatabase();

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request  servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException      if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      /* TODO output your page here. You may use following sample code. */
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet Controller</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
      out.print("This is not correct you dumb guy");
      out.println("</body>");
      out.println("</html>");
    }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
  // + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request  servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException      if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // session object to communicate data
    HttpSession session = request.getSession();
    // key word sent by the client page
    String userPath = request.getServletPath();
    // process Request(request, response);
    // Go to regular Login Page
    if (userPath.equals("/LoginPage")) {

      String myUrl = userPath + ".jsp";

      try {

        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      } catch (Exception e) {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }

    }

    // Go to the page to add a product
    else if (userPath.equals("/ItemAdded"))

    {

      //Collect the item name
      String Name = request.getParameter("Name");

      //Collect the item price
      String PriceStr = request.getParameter("Price");

      //Convert the price into a float
      Float Price = Float.parseFloat(PriceStr);
      
      //Collect the amount remaining in stock
      String QuantityStr = request.getParameter("Quantity");

      //Convert the stock into an integer
      int Quantity = Integer.parseInt(QuantityStr);
      
      //JavaDatabase AddItem = new JavaDatabase();

      //Use the method "AddFood" from another file using OOP
      UseDatabase.AddFood(Name, Price, Quantity);

      // set session variable with new data to pass back
      session.setAttribute("MyItem", Name);

      session.setAttribute("MyPrice", PriceStr);

      session.setAttribute("MyQuantity", QuantityStr);

      // Go to the correct webpage
      String myUrl = "/WEB-INF/Admin" + userPath + ".jsp";

      try {

        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      } catch (Exception e) { //Go to error page
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }

    }
    
    // Go to a page after finishing registration
    else if (userPath.equals("/RegistrationMade"))

    {

      //Read data sent by the client

      String IDstr = request.getParameter("Identity");
      
      String UserName = request.getParameter("Name");

      String PassWord = request.getParameter("Passing Word");
      
      //JavaDatabase Registration = new JavaDatabase();

      //Use the method "Register" from another file using OOP
      UseDatabase.Register(IDstr, UserName, PassWord);

      // receive data sent by the client
      String CorrectID = request.getParameter("Identity");
      
      String CorrectUserName = request.getParameter("Name");

      String CorrectPassWord = request.getParameter("Passing Word");

      // set session variable with new daata to pass back
      session.setAttribute("MyID", CorrectID);
      
      session.setAttribute("MyUser", CorrectUserName);

      session.setAttribute("MyPassword", CorrectPassWord);

      // It would be /WEB-INF/RegistrationMade.jsp
      String myUrl = "/WEB-INF/Admin" + userPath + ".jsp";

      try {

        /*
         * PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
         * 
         * ps.setString(1, UserName);
         * ps.setString(2, PassWord);
         * 
         * ps.executeUpdate();
         */
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      } catch (Exception e) {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }
    
    // Go to page after registration info be inserted
    else if (userPath.equals("/SRegistrationMade"))

    {

      // receive data sent by the client
      String IDstr = request.getParameter("Identity");
      
      String UserName = request.getParameter("Name");

      String PassWord = request.getParameter("Passing Word");
      
      //JavaDatabase SpecialRegistration = new JavaDatabase();

      //Use the method "SRegister" from another file using OOP
      UseDatabase.SRegister(IDstr, UserName, PassWord);

      // receive data sent by the client
      String CorrectID = request.getParameter("Identity");
      
      String CorrectUserName = request.getParameter("Name");

      String CorrectPassWord = request.getParameter("Passing Word");

      // set session variable with new daata to pass back
      session.setAttribute("MyID", CorrectID);
      
      session.setAttribute("MyUser", CorrectUserName);

      session.setAttribute("MyPassword", CorrectPassWord);

      // It would be /WEB-INF/RegistrationMade.jsp
      String myUrl = "/WEB-INF/Admin" + userPath + ".jsp";

      try {
        request.getRequestDispatcher(myUrl).forward(request, response);
      } catch (Exception e) {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }
    
    else if (userPath.equals("/UpAll"))

    {

      // receive data sent by the client
      String AuthentStr = request.getParameter("AuthNumb");
      
      String NName = request.getParameter("NewName");

      String PriceStr = request.getParameter("NewPrice");
      
      String QuantiStr = request.getParameter("CQuantity");
      
      Integer Authent = Integer.parseInt(AuthentStr);
      
      // Transform some values into float or string 
      Float NPrice = Float.parseFloat(PriceStr);

      Integer Quanti = Integer.parseInt(QuantiStr);
      
      //JavaDatabase ChangeEverything = new JavaDatabase();

      //Use the method "ChangeAllFoodDetails" from another file using OOP
      UseDatabase.ChangeAllFoodDetails(Authent, NName, NPrice, Quanti);

      // set session variable with new data to pass back*/
      session.setAttribute("AuthUsed", AuthentStr);

      // It would be /WEB-INF/RegistrationMade.jsp
      String myUrl = "/WEB-INF/Admin" + userPath + ".jsp";

      try {
        request.getRequestDispatcher(myUrl).forward(request, response);
      } catch (Exception e) {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }
    
    else if (userPath.equals("/UpProName"))

    {

      // receive data sent by the client
      String AuthentStr = request.getParameter("AuthNumb");
      
      String NName = request.getParameter("NewName");
      
      //JavaDatabase ChangeName = new JavaDatabase();
      
      Integer Authent = Integer.parseInt(AuthentStr);

      //Use the method "ChangeFoodName" from another file using OOP
      UseDatabase.ChangeFoodName(Authent, NName);

      // set session variable with new daata to pass back*/
      session.setAttribute("AuthUsed", AuthentStr);

      // It would be /WEB-INF/RegistrationMade.jsp
      String myUrl = "/WEB-INF/Admin" + userPath + ".jsp";

      try {
        request.getRequestDispatcher(myUrl).forward(request, response);
      } catch (Exception e) {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }
    
    else if (userPath.equals("/UpProPrice"))

    {

      // receive data sent by the client
      String AuthentStr = request.getParameter("AuthNumb");

      String PriceStr = request.getParameter("NewPrice");
      
      Integer Authent = Integer.parseInt(AuthentStr);
      
      Float NPrice = Float.parseFloat(PriceStr);
      
      //JavaDatabase ChangingPrice = new JavaDatabase();

      //Use the method "ChangePrice" from another file using OOP
      UseDatabase.ChangePrice(Authent, NPrice);

      // set session variable with new daata to pass back*/
      session.setAttribute("AuthUsed", AuthentStr);

      // It would be /WEB-INF/RegistrationMade.jsp
      String myUrl = "/WEB-INF/Admin" + userPath + ".jsp";

      try {
        request.getRequestDispatcher(myUrl).forward(request, response);
      } catch (Exception e) {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }
    
    else if (userPath.equals("/UpProQuantity"))

    {

      // receive data sent by the client
      String AuthentStr = request.getParameter("AuthNumb");
      
      String QuantiStr = request.getParameter("CQuantity");
      
      Integer Authent = Integer.parseInt(AuthentStr);

      Integer Quanti = Integer.parseInt(QuantiStr);
      
      //JavaDatabase ChangeProductQuantity = new JavaDatabase();

      //Use the method "ChangeFoodLeft" from another file using OOP
      UseDatabase.ChangeFoodLeft(Authent, Quanti);

      // set session variable with new daata to pass back*/
      session.setAttribute("AuthUsed", AuthentStr);

      // It would be /WEB-INF/RegistrationMade.jsp
      String myUrl = "/WEB-INF/Admin" + userPath + ".jsp";

      try {
        request.getRequestDispatcher(myUrl).forward(request, response);
      } catch (Exception e) {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }
    
    else if (userPath.equals("/Login"))

    {

      // receive data sent by the client
      String IDstr = request.getParameter("Identity");

      String UserName = request.getParameter("username");

      String PassWord = request.getParameter("password");
      
      //JavaDatabase CheckLogin = new JavaDatabase();

      //Use the method "AuthLog" from another file using OOP
      boolean PossibleLogin = UseDatabase.AuthLog(IDstr, UserName, PassWord);

      // receive data sent by the client
      String CorrectUserName = request.getParameter("username");

      // set session variable with new daata to pass back
      session.setAttribute("MyUser", CorrectUserName);

      // It would be /WEB-INF/RegistrationMade.jsp
      String myUrl = "/WEB-INF/ErrorLogin.jsp";

      if (PossibleLogin == true) {
        myUrl = "/WEB-INF/Regular/Login.jsp";
      }

      try {
        request.getRequestDispatcher(myUrl).forward(request, response);
      } catch (Exception e) {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }

    }
    
    else if (userPath.equals("/SpecialLogin"))

    {

      // receive data sent by the client
      String IDstr = request.getParameter("Identity");

      String UserName = request.getParameter("username");

      String PassWord = request.getParameter("password");

      //boolean PossibleLogin = JavaDatabase.SpecialAuthLog(IDstr, UserName, PassWord);

      //JavaDatabase CheckLogin = new JavaDatabase();
      
      //Use the method "SpecialAuthLog" from another file using OOP
      boolean PossibleLogin = UseDatabase.SpecialAuthLog(IDstr, UserName, PassWord);
      
      // receive data sent by the client
      String CorrectUserName = request.getParameter("username");

      // set session variable with new daata to pass back
      session.setAttribute("MyUser", CorrectUserName);

      // It would be /WEB-INF/RegistrationMade.jsp
      String myUrl = "/WEB-INF/ErrorLogin.jsp";

      if (PossibleLogin == true) {
        myUrl = "/WEB-INF/Admin/SpecialLogin.jsp";
      }

      try {
        request.getRequestDispatcher(myUrl).forward(request, response);
      } catch (Exception e) {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }

    }
    
    else if (userPath.equals("/EmployeeRemoved"))

    {
      
      // receive data sent by the client
      String IDstr = request.getParameter("Identification");
      
      Integer ID = Integer.valueOf(IDstr);
      
      //JavaDatabase RemoveEmployee = new JavaDatabase();
      
      //Use the method "EmpRemove" from another file using OOP
      UseDatabase.EmpRemove(ID);

      session.setAttribute("MyUser", IDstr);

      String myUrl = "/WEB-INF" + "/Admin" + userPath + ".jsp";

      try {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      } catch (Exception e) {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }

    }
    
    else if (userPath.equals("/ItemDeleted"))

    {
      
      String AuthNumb = request.getParameter("AuthNumb");
      
      //JavaDatabase DeleteProduct = new JavaDatabase();
      
      UseDatabase.DeleteFood(AuthNumb);

      String myUrl = "/WEB-INF" + "/Admin" + userPath + ".jsp";

      try {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      } catch (Exception e) {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }

    }

    else if (userPath.equals("/Hidden")) {

      String myUrl = "WEB-INF" + userPath + ".jsp";

      try {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      } catch (Exception e) {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }

    }
    
    else {
      processRequest(request, response);
    }

  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request  servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException      if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // session object to communicate data
    HttpSession session = request.getSession();
    // key word sent by the client page
    String userPath = request.getServletPath();
    // process Request(request, response);

    if (userPath.equals("/dbPage")) {
      // Bring what is tested
      String dbName = "WallowDataBase";
      String tableName = "Items";
      String[] columnNames = { "AuthNumb", "ItemName", "ItemPrice", "QuantityLeft" };
      JavaDatabase objDb = new JavaDatabase(dbName);
      // read the data from database
      ArrayList<ArrayList<String>> myData = objDb.getData(tableName, columnNames);
      System.out.println(myData);
      session.setAttribute("data", myData);

      // Bring what is tested Part 2
      String tableName2 = "SpecialEmployees";
      String[] columnNames2 = {"StaffID", "UserName", "Password" };
      JavaDatabase objDb2 = new JavaDatabase(dbName);
      // read the data from database
      ArrayList<ArrayList<String>> myData2 = objDb.getData(tableName2, columnNames2);
      System.out.println(myData2);

      session.setAttribute("data2", myData2);
      
      // Bring what is tested Part 3
      String tableName3 = "NormalEmployees";
      String[] columnNames3 = {"StaffID", "UserName", "Password" };
      JavaDatabase objDb3 = new JavaDatabase(dbName);
      // read the data from database
      ArrayList<ArrayList<String>> myData3 = objDb.getData(tableName3, columnNames3);
      System.out.println(myData3);

      session.setAttribute("data3", myData3);
      
      // It would be /WEB-INF/destination.jsp
      String myUrl = "/WEB-INF/Admin" + userPath + ".jsp";
      try {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      } catch (Exception e) {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }

    }
    
    else if (userPath.equals("/Items")) {
      // Bring what is tested
      String dbName = "WallowDataBase";
      String tableName = "Items";
      String[] columnNames = { "AuthNumb", "ItemName", "ItemPrice", "QuantityLeft" };
      JavaDatabase objDb = new JavaDatabase(dbName);
      // read the data from database
      ArrayList<ArrayList<String>> myData = objDb.getData(tableName, columnNames);
      System.out.println(myData);
      session.setAttribute("data", myData);

      // It would be /WEB-INF/destination.jsp
      String myUrl = "/WEB-INF/Regular" + userPath + ".jsp";
      try {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      } catch (Exception e) {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }

    }
    
    else if (userPath.equals("/DeleteItem"))

    {

      String myUrl = "/WEB-INF" + "/Admin" + userPath + ".jsp";

      try {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      } catch (Exception e) {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }

    }
    
    else if (userPath.equals("/ItemUpdating"))

    {

      String myUrl = "/WEB-INF" + "/Admin" + userPath + ".jsp";

      try {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      } catch (Exception e) {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }

    }
    
    else if (userPath.equals("/EmployeeRemoval"))

    {

      String myUrl = "/WEB-INF" + "/Admin" + userPath + ".jsp";

      try {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      } catch (Exception e) {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }

    }
    
    else if (userPath.equals("/SpecialLoginPage"))

    {

      String myUrl = userPath + ".jsp";

      try {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      } catch (Exception e) {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }

    }

    else if (userPath.equals("/AdminPage"))

    {

      String myUrl = "/WEB-INF" + "/Admin" + userPath + ".jsp";

      try {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      } catch (Exception e) {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }

    }
    
    else if (userPath.equals("/NormalEmpPage"))

    {

      String myUrl = "/WEB-INF" + "/Regular" + userPath + ".jsp";

      try {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      } catch (Exception e) {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }

    }
    
    else if (userPath.equals("/Redirect"))

    {

      String myUrl = "/WEB-INF" + userPath + ".jsp";

      try {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      } catch (Exception e) {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }

    }

    else if (userPath.equals("/AddItem"))

    {

      String myUrl = "/WEB-INF/Admin" + userPath + ".jsp";

      try {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      } catch (Exception e) {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }

    }
    
    else if (userPath.equals("/Register")) {

      String myUrl = "/WEB-INF/Admin" + userPath + ".jsp";
      
      try {

        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);

      } catch (Exception e) {

        System.out.println("You are dumb!!!");

        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }

    }

  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}

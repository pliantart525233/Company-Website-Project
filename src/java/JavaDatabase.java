/*
 * João Vítor Chaves Avila, Spring to Summer of 2023
 * Functions for the database of the website
 */

//Imports

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JavaDatabase {
  private String dbName;
  private Connection dbConn;
  private ArrayList<ArrayList<String>> data;

  public JavaDatabase() {
    dbName = "";
    dbConn = null;
    data = null;
  }

  public JavaDatabase(String dbName) {
    setDbName(dbName);
    setDbConn();
    data = null;
  }

  public String getDbName() {
    return dbName;
  }

  public void setDbName(String dbName) {
    this.dbName = dbName;
  }

  public Connection getDbConn() {
    return dbConn;
  }

  public void setDbConn() {
    String connectionURL = "jdbc:mysql://localhost:3306/" + this.dbName;
    this.dbConn = null;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      this.dbConn = DriverManager.getConnection(connectionURL, "root", "mysql1");
      // this.dbConn = DriverManager.getConnection(connectionURL);
    } catch (ClassNotFoundException ex) {
      System.out.println("Driver not found, check Library");
    } catch (SQLException se) {
      System.out.println("SQL Connection error!");
    }
  }

  public void closeDbConn() {
    try {
      this.dbConn.close();
    } catch (Exception err) {
      System.out.println("DB closing error.");
    }
  }

  public ArrayList<ArrayList<String>> getData(String tableName,
      String[] tableHeaders) {
    int columnCount = tableHeaders.length;
    Statement s = null;
    ResultSet rs = null;
    String dbQuery = "SELECT * FROM " + tableName;
    this.data = new ArrayList<>();
    // read the data
    try {
      // send the query and receive data
      s = this.dbConn.createStatement();
      rs = s.executeQuery(dbQuery);

      // read the data using rs and store in ArrayList data
      while (rs.next()) {
        // row object to hold one row data
        ArrayList<String> row = new ArrayList<>();
        // go through the row and read each cell
        for (int i = 0; i < columnCount; i++) {
          // read cell i
          // example: String cell = rs.getString("Name");
          // reads the cell in column Name
          // tableHeader={"Name", "Age", "Color"}
          String cell = rs.getString(tableHeaders[i]);
          // add the cell to the row
          // example row.add("Vinny");
          row.add(cell);
        }
        // add the row to the data
        // example: data.add "Vinny",15,"Pink"
        this.data.add(row);
      }
    } catch (SQLException se) {
      System.out.println("SQL Error: Not able to get data");
    }
    return data;
  }

  public void setData(ArrayList<ArrayList<String>> data) {
    this.data = data;
  }

  public void createDb(String newDbName) {
    setDbName(newDbName);
    Connection newConn;
    // create a db if not existing
    String connectionURL = "jdbc:mysql://localhost:3306/";
    String query = "CREATE DATABASE " + this.dbName;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      newConn = DriverManager.getConnection(connectionURL, "root", "mysql1");
      Statement s = newConn.createStatement();
      s.executeUpdate(query);
      System.out.println("New Database created!");
      newConn.close();
    } catch (ClassNotFoundException ex) {
      System.out.println("Driver not found, check library");
    } catch (SQLException se) {
      System.out.println("SQL Connection error, Db was not created!");
    }
  }

  public void createTable(String newTable, String dbName) {
    System.out.println(newTable);
    setDbName(dbName);
    setDbConn();
    Statement s;
    try {
      s = this.dbConn.createStatement();
      s.execute(newTable);
      System.out.println("New table created!");
      this.dbConn.close();
    } catch (SQLException se) {
      System.out.println("Error creating table " + newTable);
    }
  }

  // to conver a 2d arraylist to 2d array:
  public Object[][] to2dArray(ArrayList<ArrayList<String>> data) {
    if (data.size() == 0) // empty table
    {
      Object[][] dataList = new Object[0][0];
      return dataList;
    } else // table w existing data
    {
      int columnCount = data.get(0).size(); // number of columns
      Object[][] dataList = new Object[data.size()][columnCount];
      // read each cell of each row into array
      for (int r = 0; r < data.size(); r++) {
        ArrayList<String> row = data.get(r); // get the row
        for (int c = 0; c < columnCount; c++) {
          dataList[r][c] = row.get(c); // get the cell
        }
      }
      return dataList;
    }
  }

  /*
   * public static void main(String[] args)
   * {
   * // db info
   * String dbName = "Web1";
   * String tableName = "Sharks";
   * String[] columnNames = {"AN","Species", "Length", "Color"};
   * String dbQuery = "INSERT INTO Sharks VALUES (?,?,?,?)";
   * 
   * // connect to db
   * JavaDatabase objDb = new JavaDatabase(dbName);
   * Connection myDbConn = objDb.getDbConn();
   * 
   * // data to be entered (to be replaced with textfields in GUI)
   * int authencticationNumber = AuthenticationNumberCreator;
   * String species = "Tiger";
   * float length = (float) 5;
   * String color = "Gray";
   * 
   * try
   * {
   * // prepare statement
   * PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
   * // enter data into query
   * ps.setInt(1, authencticationNumber);
   * ps.setString(2, species);
   * ps.setFloat(3, length);
   * ps.setString(4, color);
   * // execute the query
   * ps.executeUpdate();
   * System.out.println("Data inserted successfully");
   * }
   * catch (SQLException se)
   * {
   * System.out.println("Error inserting data");
   * }
   * // read the data from database
   * ArrayList<ArrayList<String>> myData
   * = objDb.getData(tableName, columnNames);
   * System.out.println(myData);
   * }
   */

  /*
   * public static void main(String[] args)
   * {
   * // db info
   * String dbName = "Web1";
   * String tableName = "AccountInfo";
   * String[] columnNames = {"ProfUserName","ProfPassWord"};
   * String dbQuery = "INSERT INTO AccountInfo VALUES (?,?)";
   * 
   * // connect to db
   * JavaDatabase objDb = new JavaDatabase(dbName);
   * Connection myDbConn = objDb.getDbConn();
   * 
   * // data to be entered (to be replaced with textfields in GUI)
   * String UserName = "Plant";
   * String PassWord = "Idk";
   * 
   * try
   * {
   * // prepare statement
   * PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
   * // enter data into query
   * ps.setString(1, UserName);
   * ps.setString(2, PassWord);
   * // execute the query
   * ps.executeUpdate();
   * System.out.println("Data inserted successfully");
   * }
   * catch (SQLException se)
   * {
   * System.out.println("Error inserting data");
   * }
   * // read the data from database
   * ArrayList<ArrayList<String>> myData
   * = objDb.getData(tableName, columnNames);
   * System.out.println(myData);
   * }
   */

  public boolean AuthLog(String ID, String username, String password) // Regular login function
  {

    // db info
    String dbName = "WallowDataBase";
    String tableName = "NormalEmployees";
    String[] columnNames = { "StaffID", "UserName", "Password" };

    String dbQuery = "SELECT * FROM NormalEmployees WHERE StaffID = ? AND UserName = ? AND Password = ?";

    ResultSet Result = null;

    boolean AuthLog = false;

    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();

    try {
      //prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query
      
      ps.setString(1, ID);
      ps.setString(2, username);
      ps.setString(3, password);

      Result = ps.executeQuery();

      AuthLog = Result.next();

    } catch (Exception e) {

    }

    return AuthLog;
  }
  
  public boolean SpecialAuthLog(String ID, String username, String password) // Special login function
  {

    // db info
    String dbName = "WallowDataBase";
    String tableName = "SpecialEmployees";
    String[] columnNames = { "StaffID", "UserName", "Password" };

    String dbQuery = "SELECT * FROM SpecialEmployees WHERE StaffID = ? AND UserName = ? AND Password = ?";

    ResultSet Result = null;

    boolean SpecialAuthLog = false;

    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();

    try {
      //prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query
      
      ps.setString(1, ID);
      ps.setString(2, username);
      ps.setString(3, password);

      Result = ps.executeQuery();

      SpecialAuthLog = Result.next();

    } catch (Exception e) {

    }

    return SpecialAuthLog;
  }

  

  public void AddFood(String ProductName, Float ItPrice, int Quantity) // Add product function
  {
    // db info
    String dbName = "WallowDataBase";
    String tableName = "Items";
    String[] columnNames = { "AuthNumb", "ItemName", "ItemPrice", "QuantityLeft" };

    // insert a query, to supply values later
    String dbQuery = "INSERT INTO Items VALUES(?,?,?,?)";

    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();

    int minAnumber = 100000000;
    int MaxAnumber = 999999999;
    int AuthenticationNumberCreator = (int)Math.floor(Math.random()*(MaxAnumber-minAnumber+1)+minAnumber);

    // data to be entered
    int Auth = AuthenticationNumberCreator;

    // String Username = Controller.GetComponent<UserName>();

    try {
      //prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query

      ps.setInt(1, Auth);
      ps.setString(2, ProductName);
      ps.setFloat(3, ItPrice);
      ps.setInt(4, Quantity);

      ps.executeUpdate();
    } catch (Exception e) {

    }

  }
  
  public void Register(String ID, String Name, String Password) // Regular Register Function
  {

    // DB info
    String dbName = "WallowDataBase";
    String tableName = "NormalEmployees";
    String[] columnNames = { "StaffID", "UserName", "Password" };

    // insert a query, to supply values later
    String dbQuery = "INSERT INTO NormalEmployees VALUES(?,?,?)";

    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();

    // String Username = Controller.GetComponent<UserName>();

    try {
      //prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query

      ps.setString(1, ID);
      ps.setString(2, Name);
      ps.setString(3, Password);

      ps.executeUpdate();
    } catch (Exception e) {

    }

  }
  
  public void SRegister(String ID, String Name, String Password) // Special Register Function
  {
    // DB info
    String dbName = "WallowDataBase";
    String tableName = "SpecialEmployees";
    String[] columnNames = { "StaffID", "UserName", "Password" };

    // insert a query, to supply values later
    String dbQuery = "INSERT INTO SpecialEmployees VALUES(?,?,?)";

    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();

    // String Username = Controller.GetComponent<UserName>();

    try {
      //prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query

      ps.setString(1, ID);
      ps.setString(2, Name);
      ps.setString(3, Password);

      ps.executeUpdate();
    } catch (Exception e) {

    }

  }
  
  
  
  public void DeleteFood(String Auth) // Delete products function
  {
    //DB info
    String dbName = "WallowDataBase";
    String tableName = "Items";
    String[] columnNames = { "AuthNumb"};

    // insert a query, to supply values later
    String dbQuery = "DELETE FROM Items WHERE AuthNumb = ?";

    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();

    // String Username = Controller.GetComponent<UserName>();

    try {
      //prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query

      ps.setString(1, Auth);
      
      ps.executeUpdate();
    } catch (Exception e) {

    }

  }
  
  public void EmpRemove(Integer Id) // Remove Employee function
  {
    //DB info
    String dbName = "WallowDataBase";
    String tableName = "NormalEmployees";
    String[] columnNames = { "StaffID"};

    // insert a query, to supply values later
    String dbQuery = "DELETE FROM NormalEmployees WHERE StaffID = ?";

    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();

    // String Username = Controller.GetComponent<UserName>();

    try {
      //prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query

      ps.setInt(1, Id);
      
      ps.executeUpdate();
    } catch (Exception e) {

    }

  }
  
  public void ChangeAllFoodDetails(Integer Auth, String Name, Float Price, Integer Left) // Change All products information function
  {
    //DB info
    String dbName = "WallowDataBase";
    String tableName = "Items";
    String[] columnNames = { "AuthNumb", "ItemName", "ItemPrice", "QuantityLeft"};

    // insert a query, to supply values later
    String dbQuery = "UPDATE Items SET ItemName = ?, ItemPrice = ?, QuantityLeft = ? WHERE AuthNumb = ?";

    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();

    // String Username = Controller.GetComponent<UserName>();

    try {
      //prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query

      
      ps.setString(1, Name);
      ps.setFloat(2, Price);
      ps.setInt(3, Left);
      ps.setInt(4, Auth);
      
      ps.executeUpdate();
    } catch (Exception e) {

    }

  }
  
  public void ChangeFoodName(Integer Auth, String Name) // Change product name function
  {
    //DB info
    String dbName = "WallowDataBase";
    String tableName = "Items";
    String[] columnNames = { "AuthNumb", "ItemName"};

    // insert a query, to supply values later
    String dbQuery = "UPDATE Items SET ItemName = ? WHERE AuthNumb = ?";

    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();

    // String Username = Controller.GetComponent<UserName>();

    try {
      //prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query

      ps.setString(1, Name);
      ps.setInt(2, Auth);

      ps.executeUpdate();
    } catch (Exception e) {

    }

  }
  
  public void ChangePrice(Integer Auth, Float Price) // Change product price function
  {
    //DB info
    String dbName = "WallowDataBase";
    String tableName = "Items";
    String[] columnNames = { "AuthNumb", "ItemPrice"};

    // insert a query, to supply values later
    String dbQuery = "UPDATE Items SET ItemPrice = ? WHERE AuthNumb = ?";
    
    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();

    // String Username = Controller.GetComponent<UserName>();

    try {
      //prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query

      ps.setFloat(1, Price);
      ps.setInt(2, Auth);

      ps.executeUpdate();
    } catch (Exception e) {

    }

  }
  
  public void ChangeFoodLeft(Integer Auth, Integer Left) // Change food Stock function
  {
    //DB info
    String dbName = "WallowDataBase";
    String tableName = "Items";
    String[] columnNames = { "AuthNumb", "QuantityLeft"};

    // insert a query, to supply values later
    String dbQuery = "UPDATE Items SET QuantityLeft = ? WHERE AuthNumb = ?";

    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();

    // String Username = Controller.GetComponent<UserName>();

    try {
      //prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query

      ps.setInt(1, Left);
      ps.setInt(2, Auth);
      
      ps.executeUpdate();
    } catch (Exception e) {

    }

  }
  
  /*public static void main (String[] args)
  {
    String dbName = "WallowDataBase";
    String tableName = "Items";
    String[] columnNames = { "AuthNumb", "ItemName", "ItemPrice", "QuantityLeft"};

    // insert a query, to supply values later
    String dbQuery = "UPDATE Items SET ItemName = ?, ItemPrice = ?, QuantityLeft = ? WHERE AuthNumb = ?";

    int Auth = 806506976;
    String Name = "2222";
    float Price = 24;
    int Left = 12;
    
    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();

    // String Username = Controller.GetComponent<UserName>();

    try {
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);

      
      ps.setString(1, Name);
      ps.setFloat(2, Price);
      ps.setInt(3, Left);
      ps.setInt(4, Auth);
      
      ps.executeUpdate();
      System.out.println("Data updated successfully");
    } catch (Exception e) {

    }

  }*/

}

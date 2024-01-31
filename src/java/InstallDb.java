/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 /*
 * João Vítor Chaves Avila, Spring to Summer of 2023
 * Create the Databases and Tables
 */

/**
 *
 * @author jvavi
 */
public class InstallDb {

  public static void main(String[] args) {
    String dbName = "WallowDataBase";
    // Creating an object of DB class
    JavaDatabase objDb = new JavaDatabase();
    // creating a new database
    objDb.createDb(dbName);
    // creating a new table
    String newTable = "CREATE TABLE Items(AuthNumb int, ItemName varchar(50), ItemPrice float, QuantityLeft int )";
    objDb.createTable(newTable, dbName);
    String newTable2 = "CREATE TABLE SpecialEmployees(StaffID int, UserName varchar(50), Password varchar(50) )";
    objDb.createTable(newTable2, dbName);
    String newTable3 = "CREATE TABLE NormalEmployees(StaffID int, UserName varchar(50), Password varchar(50) )";
    objDb.createTable(newTable3, dbName);
    // creating a second table
    // String myNewTable = "CREATE TABLE Cars2 (Name2 varchar(50),"
    // + "Price2 int, Color2 varchar(50) )";
    // objDb.createTable(myNewTable, dbName);

  }

}

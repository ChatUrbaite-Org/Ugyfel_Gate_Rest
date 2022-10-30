package com.project.ugyfel_gate_rest.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_DataBase_With_Tables
{
    /*
    private final String jdbcDriver = LoadMySQL.getDriverName();
    private final String dbAddress = LoadMySQL.getAddress();
    private final String userPass = LoadMySQL.getUserPass();
    private final String dbName = LoadMySQL.getDBName();
    private final String userName = LoadMySQL.getUserName();
    private final String password = LoadMySQL.getPassword();
    */
    private final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    private final String dbAddress = "jdbc:mysql://localhost:3306/";
    private final String userPass = "?user=root&password=";
    private final String dbName = "projekt";
    private final String userName = "root";
    private final String password = "";

    private Statement statement;
    private Connection con;
    public Create_DataBase_With_Tables()
    {
        new LoadMySQL();
        try
        {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            try
            {
                new LoadMySQL();
                createDatabase();
                createUsersTable();
                createLocationsTable();
                createOrganisationsTable();
                createIDCardTable();
                createLocationCardTable();
                createDriversLicenseTable();
                createMessagesTable();
            }
            catch (Exception exception)
            {
                System.out.println("An error occured: "+exception);
            }
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            createDatabase();
        }
    }
    void createDatabase()
    {
        try
        {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbAddress + userPass);
            Statement s = con.createStatement();
            s.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    void createUsersTable()
    {
        String myTableName = "CREATE TABLE Users ("
                + "id INT(64) NOT NULL AUTO_INCREMENT Primary Key,"
                + "uname VARCHAR(236),"
                + "userName VARCHAR(236),"
                + "password VARCHAR(236),"
                + "email VARCHAR(236),"
                + "birthDate DATE,"
                + "birthPlace VARCHAR(36),"
                + "sex VARCHAR(10),"
                + "isActive INT(1),"
                + "isMom INT(1),"
                + "girlName VARCHAR(236),"
                + "nationality VARCHAR(36))";
        try
        {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            statement = con.createStatement();
            //The next line has the issue
            statement.executeUpdate(myTableName);
            System.out.println("Table Created");
        }
        catch (SQLException e )
        {
            System.out.println("An error has occurred on Table Creation: "+e);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("An Mysql drivers were not found"+e);
        }
    }
    void createLocationsTable()
    {
        String myTableName = "CREATE TABLE Locations ("
                + "id INT(64) NOT NULL AUTO_INCREMENT Primary Key,"
                + "country VARCHAR(236),"
                + "county VARCHAR(236),"
                + "city VARCHAR(236),"
                + "street VARCHAR(236),"
                + "rest VARCHAR(236),"
                + "houseNumber Int(10),"
                + "registrationDate Date,"
                + "expirationDate Date)";
        try
        {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            statement = con.createStatement();
            //The next line has the issue
            statement.executeUpdate(myTableName);
            System.out.println("Table Created");
        }
        catch (SQLException e )
        {
            System.out.println("An error has occurred on Table Creation: "+e);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("An Mysql drivers were not found"+e);
        }
    }
    void createOrganisationsTable()
    {
        String myTableName = "CREATE TABLE Organisations ("
                + "id INT(64) NOT NULL AUTO_INCREMENT Primary Key,"
                + "oname VARCHAR(236),"
                + "location INT(64),"
                + "Foreign Key (location) References locations(id) ,"
                + "nationality VARCHAR(236))";
        try
        {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            statement = con.createStatement();
            //The next line has the issue
            statement.executeUpdate(myTableName);
            System.out.println("Table Created");
        }
        catch (SQLException e )
        {
            System.out.println("An error has occurred on Table Creation: "+e);
        }
        catch (ClassNotFoundException e) {
            System.out.println("An Mysql drivers were not found"+e);
        }
    }
    void createIDCardTable()
    {
        String myTableName = "CREATE TABLE IDCard ("
                + "id INT(64) NOT NULL AUTO_INCREMENT Primary Key,"
                + "userid INT(64),"
                + "FOREIGN KEY (userid)  REFERENCES users(id) ,"
                + "cardNumber VARCHAR(10),"
                + "can INT(6),"
                + "fingerprint INT(1),"
                + "orgid int(64),"
                + "FOREIGN KEY (orgid) REFERENCES organisations(id), "
                + "expirationDate DATE)";
        try
        {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            statement = con.createStatement();
            //The next line has the issue
            statement.executeUpdate(myTableName);
            System.out.println("Table Created");
        }
        catch (SQLException e )
        {
            System.out.println("An error has occurred on Table Creation: "+e);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("An Mysql drivers were not found"+e);
        }
    }
    void createLocationCardTable()
    {
        String myTableName = "CREATE TABLE LocationCard ("
                + "id INT(64) NOT NULL AUTO_INCREMENT Primary Key,"
                + "userid INT(64),"
                + "Foreign Key (userid) References users(id) ,"
                + "cardNumber VARCHAR(10),"
                + "defaultlocation INT(64),"
                + "Foreign Key (defaultlocation) References locations(id),"
                + "residentallocation INT(64),"
                + "Foreign Key (residentallocation) References locations(id), "
                + "orgid INT(64), "
                + "Foreign Key (orgid) References organisations(id)"
                + ")";
        try
        {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            statement = con.createStatement();
            //The next line has the issue
            statement.executeUpdate(myTableName);
            System.out.println("Table Created");
        }
        catch (SQLException e )
        {
            System.out.println("An error has occurred on Table Creation: "+e);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("An Mysql drivers were not found"+e);
        }
    }
    void createDriversLicenseTable()
    {
        String myTableName = "CREATE TABLE DriversLicense ("
                + "id INT(64) NOT NULL AUTO_INCREMENT Primary Key,"
                + "uid INT(64),"
                + "Foreign Key (uid) References users(id) ,"
                + "cardNumber VARCHAR(10),"
                + "orgid INT(64),"
                + "acquireDate DATE,"
                + "expirationDate DATE,"
                + "Foreign Key (orgid) References organisations(id)"
                + ")";
        try
        {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            statement = con.createStatement();
            //The next line has the issue
            statement.executeUpdate(myTableName);
            System.out.println("Table Created");
        }
        catch (SQLException e )
        {
            System.out.println("An error has occurred on Table Creation: "+e);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("An Mysql drivers were not found"+e);
        }
    }
    void createMessagesTable()
    {
        String myTableName = "CREATE TABLE Messages ("
                + "id INT(64) NOT NULL AUTO_INCREMENT Primary Key,"
                + "uid INT(64),"
                + "Foreign Key (uid) References users(id) ,"
                + "Subject VARCHAR(10),"
                + "message VARCHAR(236),"
                + "orgid INT(64),"
                + "Foreign Key (orgid) References organisations(id),"
                + "arriveTime DATE,"
                + "deadline DATE,"
                + "isRead INT(1),"
                + "hasDocs INT(1)"
                + ")";
        try
        {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            statement = con.createStatement();
            //The next line has the issue
            statement.executeUpdate(myTableName);
            System.out.println("Table Created");
        }
        catch (SQLException e )
        {
            System.out.println("An error has occurred on Table Creation: "+e);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("An Mysql drivers were not found"+e);
        }
    }
}

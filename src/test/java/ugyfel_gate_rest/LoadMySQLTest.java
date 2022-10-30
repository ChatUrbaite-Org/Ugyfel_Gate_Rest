package ugyfel_gate_rest;

import com.project.ugyfel_gate_rest.DataBase.LoadMySQL;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoadMySQLTest
{
    public LoadMySQLTest() {
        LoadMySQL load = new LoadMySQL();
    }
    @Test
    public void DriverTest() throws SQLException
    {
        assertEquals("com.mysql.cj.jdbc.Driver", LoadMySQL.getDriverName());
    }
    @Test
    public void AddressTest() throws SQLException
    {
        assertEquals("jdbc:mysql://localhost:3306/", LoadMySQL.getAddress());
    }
    @Test
    public void UserPassTest() throws SQLException
    {
        assertEquals("?user=root&password=", LoadMySQL.getUserPass());
    }

    @Test
    public void DBNameTest() throws SQLException
    {
        assertEquals("projekt", LoadMySQL.getDBName());
    }
    @Test
    public void UserNameTest() throws SQLException
    {
        assertEquals("root", LoadMySQL.getUserName());
    }
    @Test
    public void PasswordTest() throws SQLException
    {
        assertEquals("", LoadMySQL.getPassword());
    }
}

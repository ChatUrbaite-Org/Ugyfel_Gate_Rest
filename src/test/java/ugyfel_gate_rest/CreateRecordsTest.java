package ugyfel_gate_rest;

import com.project.ugyfel_gate_rest.Classes.*;
import com.project.ugyfel_gate_rest.DataBase.Create_DataBase_With_Tables;
import com.project.ugyfel_gate_rest.DataBase.GetArray;
import com.project.ugyfel_gate_rest.DataBase.GetId;
import com.project.ugyfel_gate_rest.DataBase.Insert_Into_DataBase;
import com.project.ugyfel_gate_rest.Enums.Nationality;
import com.project.ugyfel_gate_rest.Classes.MD5;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

public class CreateRecordsTest
{
    Insert_Into_DataBase insert = new Insert_Into_DataBase();

    User user= new User("Hegedüs János", "JaniHegedus", MD5.Translate_to_MD5_HASH("Jancsika20"), "hegedusjanos2002@gmail.com", Date.valueOf("2002-11-13"), "Szigetvár","Ferfi", true, false, "", "HUNGARIAN");
    User user1= new User("Cool Michael", "KingM", MD5.Translate_to_MD5_HASH("nopassword"), "cool69@gmail.com", Date.valueOf("1999-06-07"), "Nyíregyháza","Ferfi", true, true, "misipisi", "JAPANESE");
    User user2= new User("Poor Michael", "PoorM", MD5.Translate_to_MD5_HASH("FAILURE"), "failure96@gmail.com", Date.valueOf("1999-07-06"), "Poorháza","Egyeb", true, true, "", "RUSSIAN");
    Location location = new Location("Hungary","Baranya","Pecs","Garay Janos",32,"B/14",Date.valueOf("2022-08-01"),Date.valueOf("2024-08-01"));
    Location location1 = new Location("Hungary","Baranya","Mozsgo","Arpad",18,"",Date.valueOf("2002-11-13"));
    Organisation organisation = new Organisation("BelügyMinisztérium",location, Nationality.HUNGARIAN);
    Organisation organisation1 = new Organisation("KülügyMinisztérium",location1, Nationality.HUNGARIAN);
    ID_CARD idCard = new ID_CARD(2123,user,organisation,"21321139es",false,Date.valueOf("2022-11-13"),Nationality.HUNGARIAN);
    ID_CARD idCard1 = new ID_CARD(2133,user1,organisation1,"21321139ed",false,Date.valueOf("2022-11-13"),Nationality.HUNGARIAN);
    ID_CARD idCard2 = new ID_CARD(2143,user2,organisation,"21321139ef",false,Date.valueOf("2022-11-13"),Nationality.HUNGARIAN);
    Location_CARD location_card = new Location_CARD("asd123dew",location,location1,user,organisation);
    Location_CARD location_card1 = new Location_CARD("123345678A",location,user,organisation);
    Drivers_License driversLicense = new Drivers_License(user,"sdadsa",Date.valueOf("2021-07-01"),Date.valueOf("2031-07-01"),organisation);
    Message message = new Message(user,organisation,"Befizetés","Önnek egy befizetetlen számlája van!",Date.valueOf("2022-10-26"),Date.valueOf("2022-11-26"),false,false);

    public CreateRecordsTest() throws NoSuchAlgorithmException
    {
        Create_DataBase_With_Tables createDataBaseWithTables = new Create_DataBase_With_Tables();
    }

    @Test
    public void UserTest() throws SQLException {

        insert.insertIntoUserTable(user);
        insert.insertIntoUserTable(user1);
        insert.insertIntoUserTable(user2);
        assertEquals(3, GetArray.getDataFromUserTable().size());
    }
    @Test
    public void LocationTest() throws SQLException
    {
        insert.insertIntoLocationsTable(location);
        insert.insertIntoLocationsTable(location1);
        GetArray.getDataFromLocationsTable();
        assertEquals(2, GetArray.getDataFromLocationsTable().size());
        assertEquals(1, GetId.getlocationID(location));
        assertEquals(2, GetId.getlocationID(location1));
    }
    @Test
    public void OrgTest () throws SQLException
    {
        insert.insertIntoOrganisationsTable(organisation);
        insert.insertIntoOrganisationsTable(organisation1);
        assertEquals(2, GetArray.getDataFromOrganisationsTable().size());
    }
    @Test
    public void LocationCardTest() throws SQLException {
        insert.insertIntoLocationCardTable(location_card);
        insert.insertIntoLocationCardTable(location_card1);
        assertEquals(2,GetArray.getDataFromLocationCardTable().size());
    }
    @Test
    public void DriversLicenseTest() throws SQLException {
        insert.insertIntoDriversLicenseTable(driversLicense);
        assertEquals(1,GetArray.getDataFromDriversLicenseTable().size());
    }
    @Test
    public void MessagesTest() throws SQLException {
        insert.insertIntoMessagesTable(message);
        assertEquals(1,GetArray.getDataFromMessagesTable().size());
    }
    @Test
    public void IDCTest() throws SQLException {
        for (ID_CARD id_card : Arrays.asList(idCard, idCard1, idCard2)) {
            insert.insertIntoIDCardTable(id_card);
        }
        if(GetArray.getDataFromIDCardTable().size()==2)//először 2 aztán 3 mert 1 record törölve lesz idő közben
        {
            assertEquals(3, GetArray.getDataFromIDCardTable().size());
        }
        else
        {
            assertEquals(3, GetArray.getDataFromIDCardTable().size());
        }
    }
}

package ugyfel_gate_rest;


import com.project.ugyfel_gate_rest.Classes.*;
import com.project.ugyfel_gate_rest.DataBase.*;
import com.project.ugyfel_gate_rest.DataBase.Insert_Into_DataBase;
import com.project.ugyfel_gate_rest.Enums.*;
import com.project.ugyfel_gate_rest.Classes.MD5;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;

import static junit.framework.Assert.assertEquals;


public class IdTest
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
    public IdTest() throws NoSuchAlgorithmException {

    }

    @Test
    public void LocIdTest()
    {
        assertEquals(1,GetId.getlocationID(location));
        assertEquals(2,GetId.getlocationID(location1));
    }
    @Test
    public void UserIdTest() {
        assertEquals(1,GetId.getUserId(user));
        assertEquals(2,GetId.getUserId(user1));
    }
    @Test
    public void OrgIdTest()
    {
        assertEquals(1,GetId.getOrgId(organisation));
        assertEquals(2,GetId.getOrgId(organisation1));
    }


}

package ugyfel_gate_rest;

import com.project.ugyfel_gate_rest.Classes.Location;
import com.project.ugyfel_gate_rest.Classes.Organisation;
import com.project.ugyfel_gate_rest.Classes.User;
import com.project.ugyfel_gate_rest.DataBase.GetArray;
import com.project.ugyfel_gate_rest.Rest.GetJSON;
import com.project.ugyfel_gate_rest.Classes.MD5;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

public class JSONTest
{
    User user = GetArray.getDataFromUserTable().get(2);
    Organisation organisation = GetArray.getDataFromOrganisationsTable().get(0);
    Location location = GetArray.getDataFromLocationsTable().get(0);
    @Test
    public void UserJSONTest() throws NoSuchAlgorithmException
    {
        GetJSON.getJSONData("JaniHegedus", MD5.Translate_to_MD5_HASH("Jancsika20"));
    }
    @Test
    public void LocationJSONTest()
    {
        GetJSON.getJSONDLocation(location);
    }
    @Test
    public void OrganisationJSONTest()
    {
        GetJSON.getJSONORG(organisation);
    }
    @Test
    public void LocationCardJSONTest()
    {
        GetJSON.getJSONLocationCard(user);
    }
    @Test
    public void IdCardJSONTest()
    {
        GetJSON.getJSONIDCard(user);
    }
    @Test
    public void DriversLicenseJSONTest()
    {
        GetJSON.getJSONDriversLicense(user);
    }
}

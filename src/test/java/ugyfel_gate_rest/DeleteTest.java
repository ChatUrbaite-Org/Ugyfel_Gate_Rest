package ugyfel_gate_rest;

import com.project.ugyfel_gate_rest.DataBase.DeleteData;
import org.junit.Test;

public class DeleteTest
{
    @Test
    public void deleteUserTest()
    {
        DeleteData.deleteUser(3);
    }
    @Test
    public void deleteLocationTest()
    {
        DeleteData.deleteLocation(3);
    }
    @Test
    public void deleteOrganisationTest()
    {
        DeleteData.deleteOrganisation(3);
    }
    @Test
    public void deleteIDCardTest()
    {
        DeleteData.deleteIDCard(3);
    }
    @Test
    public void deleteLocationCardTest()
    {
        DeleteData.deleteLocationCard(3);
    }
    @Test
    public void deleteDriversLicenseTest()
    {
        DeleteData.deleteDriversLicense(3);
    }
    @Test
    public void deleteMessageTest()
    {
        DeleteData.deleteMessage(3);
    }
}

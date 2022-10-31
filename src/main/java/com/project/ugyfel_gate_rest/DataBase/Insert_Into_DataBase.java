package com.project.ugyfel_gate_rest.DataBase;

import com.project.ugyfel_gate_rest.Classes.*;
import com.project.ugyfel_gate_rest.Enums.Nationality;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;

public class Insert_Into_DataBase
{
    public Insert_Into_DataBase()
    {
        new LoadMySQL();
    }
    public void insertIntoUserTable(@NotNull User user) throws SQLException {
        String Uname = user.getName();
        String UserName =user.getUsername();
        String Password = user.getPassword();
        String Email = String.valueOf(user.getEmail());
        Date BirthDate= (Date) user.getBirthdate();
        String BirthPlace=user.getBirthplace();
        String sex = user.getSex().toString();
        boolean isActive=user.isActive();
        boolean IsMom=user.isMom();
        String GirlName=user.getGirlName();
        String Nationality=user.getNationality().toString();
        Statement st;
        int active= 0;
        int Mom =0;
        if(isActive) active = 1;
        if(IsMom) Mom = 1;
        Connection con = DriverManager.getConnection(LoadMySQL.getAddress() + LoadMySQL.getDBName(), LoadMySQL.getUserName(), LoadMySQL.getPassword());
        ArrayList<User> users = GetArray.getDataFromUserTable();
        ArrayList<String> userNamesTaken = new ArrayList<>();
        for (User user0 : users)
        {
            userNamesTaken.add(user0.getUsername());
        }
        if(!userNamesTaken.contains(UserName))
        {
            try
            {
                st = con.createStatement();
                String accessDatabase = "insert into Users("
                        + "uname,"
                        + "userName,"
                        + "password,"
                        + "email,"
                        + "birthDate,"
                        + "birthPlace,"
                        + "sex,"
                        + "isActive,"
                        + "isMom,"
                        + "girlName,"
                        + "nationality)"
                        + " values('"
                        +Uname+"','"
                        +UserName+"','"
                        +Password+"','"
                        +Email+"','"
                        +BirthDate+"','"
                        +BirthPlace+"','"
                        +sex+"','"
                        +active+"','"
                        +Mom+"','"
                        +GirlName+"','"
                        +Nationality+"') ";
                int result = st.executeUpdate(accessDatabase);

                if (result > 0)
                {
                    System.out.println("Record Inserted! Check your table now!");
                }
                con.close();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }else {
            System.out.println("UserName is Taken!");
        }
    }
    public void insertIntoLocationsTable(@NotNull Location location) throws SQLException
    {
        ArrayList<Location> usedlocations = GetArray.getDataFromLocationsTable();
        ArrayList<String> alltogethers =new ArrayList<>();
        for (Location usedlocation : usedlocations)
        {
            String allintogether = usedlocation.getCountry()+usedlocation.getCounty()+usedlocation.getCity()+usedlocation.getStreet()+ usedlocation.getRest()+usedlocation.getRegistration_date();
            alltogethers.add(allintogether);
        }
        String given = location.getCountry()+location.getCounty()+location.getCity()+location.getStreet()+ location.getRest()+location.getRegistration_date();
        if(!alltogethers.contains(given))
        {
            String country = location.getCountry();
            String county = location.getCounty();
            String city = location.getCity();
            String street = location.getStreet();
            int house_number = location.getHouse_number();
            Date registration_date = (Date) location.getRegistration_date();
            Date expiration_date = Date.valueOf("0001-01-01");
            if (location.getExpiration_date() != null)
            {
                expiration_date = (Date) location.getExpiration_date();
            }

            String rest = location.getRest();
            Statement st;

            Connection con = DriverManager.getConnection(LoadMySQL.getAddress() + LoadMySQL.getDBName(), LoadMySQL.getUserName(), LoadMySQL.getPassword());
            try
            {
                st = con.createStatement();
                String accessDatabase = "insert into Locations("
                        + "country,"
                        + "county,"
                        + "city,"
                        + "street,"
                        + "houseNumber,"
                        + "registrationDate,"
                        + "expirationdate,"
                        + "rest)"
                        + " values('"
                        + country + "','"
                        + county + "','"
                        + city + "','"
                        + street + "','"
                        + house_number + "','"
                        + registration_date + "','"
                        + expiration_date + "','"
                        + rest
                        + "') ";
                int result = st.executeUpdate(accessDatabase);

                if (result > 0)
                {
                    System.out.println("Record Inserted! Check your table now!");
                }
                con.close();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }else{
            System.out.println("Record already Created");
        }
    }
    public void insertIntoOrganisationsTable(@NotNull Organisation organisation) throws SQLException
    {
        ArrayList<Organisation> usedorganisations = GetArray.getDataFromOrganisationsTable();
        ArrayList<String> orgs =new ArrayList<>();
        for (Organisation usedorg : usedorganisations)
        {
            String names = usedorg.getName();
            orgs.add(names);
        }
        String given = organisation.getName();
        if(!orgs.contains(given))
        {
            String orgname = organisation.getName();
            Location location = organisation.getLocation();
            int locationid = GetId.getlocationID(location);
            Nationality nationality = organisation.getNationality();
            Statement st;
            Connection con = DriverManager.getConnection(LoadMySQL.getAddress() + LoadMySQL.getDBName(), LoadMySQL.getUserName(), LoadMySQL.getPassword());
            try
            {
                st = con.createStatement();
                String accessDatabase = "insert into Organisations("
                        + "oname,"
                        + "location,"
                        + "nationality"
                        + ")"
                        + " values('"
                        + orgname + "','"
                        + locationid + "','"
                        + nationality
                        + "') ";
                int result = st.executeUpdate(accessDatabase);

                if (result > 0)
                {
                    System.out.println("Record Inserted! Check your table now!");
                }
                con.close();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }else{
            System.out.println("Record already Created");
        }
    }
    public void insertIntoIDCardTable(@NotNull ID_CARD id_card) throws SQLException {
        ArrayList<ID_CARD> usedlocations = GetArray.getDataFromIDCardTable();
        ArrayList<String> alltogethers =new ArrayList<>();
        for (ID_CARD usedid : usedlocations)
        {
            String allintogether = usedid.getId_num();
            alltogethers.add(allintogether);
        }
        String given = id_card.getId_num();
        if(!alltogethers.contains(given))
        {
            String id_num = id_card.getId_num();
            int userid = GetId.getUserId(id_card.getUser());
            //System.out.println(GetId.getUserId(id_card.getUser()));
            int orgid =GetId.getOrgId(id_card.getOrgan());
            //System.out.println(GetId.getOrgId(id_card.getOrgan()));
            int CAN_number = id_card.getCAN_number();
            int fingerprint =0;
            if(id_card.isFinger_print()) fingerprint = 1;
            Date from_date = (Date) id_card.getExpiry();
            Connection con = DriverManager.getConnection(LoadMySQL.getAddress() + LoadMySQL.getDBName(), LoadMySQL.getUserName(), LoadMySQL.getPassword());
            Statement st;
            try
            {
                st = con.createStatement();
                String accessDatabase = "insert into IDCard("
                        + "userid,"
                        + "cardNumber,"
                        + "can,"
                        + "fingerprint,"
                        + "orgid,"
                        + "expirationDate"
                        + ")"
                        + " values('"
                        + userid + "','"
                        + id_num + "','"
                        + CAN_number + "','"
                        + fingerprint + "','"
                        + orgid + "','"
                        + from_date
                        + "') ";
                int result = st.executeUpdate(accessDatabase);

                if (result > 0)
                {
                    System.out.println("Record Inserted! Check your table now!");
                }
                con.close();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }else{
            System.out.println("Record already Created");
        }
    }
    public void insertIntoLocationCardTable(@NotNull Location_CARD location_card) throws SQLException {
        ArrayList<Location_CARD> usedcards = GetArray.getDataFromLocationCardTable();
        ArrayList<String> alltogethers =new ArrayList<>();
        for (Location_CARD card : usedcards)
        {
            String allintogether = card.getLoc_Id();
            alltogethers.add(allintogether);
        }
        String given = location_card.getLoc_Id();
        if(!alltogethers.contains(given))
        {
            String loc_id = location_card.getLoc_Id();
            int userid = GetId.getUserId(location_card.getUser());
            int orgid = GetId.getOrgId(location_card.getOrganisation());
            int dlocationid = GetId.getlocationID(location_card.getDefaultlocation());
            if(location_card.getResidentallocation()==null)
            {
                Connection con = DriverManager.getConnection(LoadMySQL.getAddress() + LoadMySQL.getDBName(), LoadMySQL.getUserName(), LoadMySQL.getPassword());
                Statement st;
                try
                {
                    st = con.createStatement();
                    String accessDatabase = "insert into LocationCard("
                            + "userid,"
                            + "cardNumber,"
                            + "defaultlocation,"
                            + "orgid"
                            + ")"
                            + " values('"
                            + userid + "','"
                            + loc_id + "','"
                            + dlocationid + "','"
                            + orgid
                            + "') ";
                    int result = st.executeUpdate(accessDatabase);

                    if (result > 0)
                    {
                        System.out.println("Record Inserted! Check your table now!");
                    }
                    con.close();
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                int rlocationid = GetId.getlocationID(location_card.getResidentallocation());
                Connection con = DriverManager.getConnection(LoadMySQL.getAddress() + LoadMySQL.getDBName(), LoadMySQL.getUserName(), LoadMySQL.getPassword());
                Statement st;
                String sql = ("SELECT * FROM Users ORDER BY id DESC;");
                try
                {
                    st = con.createStatement();
                    st.executeQuery(sql);
                    String accessDatabase = "insert into LocationCard("
                            + "userid,"
                            + "cardNumber,"
                            + "defaultlocation,"
                            + "residentallocation,"
                            + "orgid"
                            + ")"
                            + " values('"
                            + userid + "','"
                            + loc_id + "','"
                            + dlocationid + "','"
                            + rlocationid + "','"
                            + orgid
                            + "') ";
                    int result = st.executeUpdate(accessDatabase);

                    if (result > 0)
                    {
                        System.out.println("Record Inserted! Check your table now!");
                    }
                    con.close();
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }else{
            System.out.println("Record already Created");
        }
    }
    public void insertIntoDriversLicenseTable(@NotNull Drivers_License driversLicense) throws SQLException {
        ArrayList<Drivers_License> usedlocations = GetArray.getDataFromDriversLicenseTable();
        ArrayList<String> alltogethers =new ArrayList<>();
        for (Drivers_License drivers_license : usedlocations)
        {
            String allintogether = drivers_license.getCard_number();
            alltogethers.add(allintogether);
        }
        String given = driversLicense.getCard_number();
        if(!alltogethers.contains(given))
        {
            String card_number = driversLicense.getCard_number();
            int userid = GetId.getUserId(driversLicense.getUser());
            int orgid =GetId.getOrgId(driversLicense.getOrgan());
            Date acquireDate = (Date) driversLicense.getAcquire();
            Date expiryDate = (Date) driversLicense.getExpiry();
            Connection con = DriverManager.getConnection(LoadMySQL.getAddress() + LoadMySQL.getDBName(), LoadMySQL.getUserName(), LoadMySQL.getPassword());
            Statement st;
            try
            {
                st = con.createStatement();
                String accessDatabase = "insert into DriversLicense("
                        + "uid,"
                        + "cardNumber,"
                        + "orgid,"
                        + "expirationDate,"
                        + "acquireDate"
                        + ")"
                        + " values('"
                        + userid + "','"
                        + card_number + "','"
                        + orgid + "','"
                        + acquireDate + "','"
                        + expiryDate
                        + "') ";
                int result = st.executeUpdate(accessDatabase);

                if (result > 0)
                {
                    System.out.println("Record Inserted! Check your table now!");
                }
                con.close();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }else{
            System.out.println("Record already Created");
        }
    }
    public void insertIntoMessagesTable(@NotNull Message message) throws SQLException {
        ArrayList<Message> oldmessages = GetArray.getDataFromMessagesTable();
        ArrayList<String> alltogethers =new ArrayList<>();
        for (Message message0 : oldmessages)
        {
            String allintogether = message0.getMessage()+message0.getSubject();
            alltogethers.add(allintogether);
        }
        String given = message.getMessage()+message.getSubject();
        if(!alltogethers.contains(given))
        {
            String subject = message.getSubject();
            String content = message.getMessage();
            int userid = GetId.getUserId(message.getUser());
            int orgid =GetId.getOrgId(message.getOrganisation());
            Date arriveTime = (Date) message.getArriveTime();
            Date deadline = (Date) message.getDeadline();
            int isRead = 0;
            if(message.isRead()) isRead=1;
            int givenDocs = 0;
            if(message.getDocuments()) givenDocs=1;
            Connection con = DriverManager.getConnection(LoadMySQL.getAddress() + LoadMySQL.getDBName(), LoadMySQL.getUserName(), LoadMySQL.getPassword());
            Statement st;
            try
            {
                st = con.createStatement();
                String accessDatabase = "insert into Messages("
                        + "uid,"
                        + "Subject,"
                        + "message,"
                        + "orgid,"
                        + "arriveTime,"
                        + "deadline,"
                        + "isRead,"
                        + "hasDocs"
                        + ")"
                        + " values('"
                        + userid + "','"
                        + subject + "','"
                        + content + "','"
                        + orgid + "','"
                        + arriveTime + "','"
                        + deadline+ "','"
                        + isRead+ "','"
                        + givenDocs
                        + "') ";
                int result = st.executeUpdate(accessDatabase);

                if (result > 0)
                {
                    System.out.println("Record Inserted! Check your table now!");
                }
                con.close();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }else{
            System.out.println("Record already Created");
        }
    }
}

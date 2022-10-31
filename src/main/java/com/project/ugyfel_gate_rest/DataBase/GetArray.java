package com.project.ugyfel_gate_rest.DataBase;

import com.project.ugyfel_gate_rest.Classes.*;
import com.project.ugyfel_gate_rest.Enums.Nationality;
import com.project.ugyfel_gate_rest.Enums.Sex;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class GetArray
{
    private static final String jdbcDriver = LoadMySQL.getDriverName();
    private static final String dbAddress = LoadMySQL.getAddress();
    private static final String userPass = LoadMySQL.getUserPass();
    private static final String dbName = LoadMySQL.getDBName();
    private static final String userName = LoadMySQL.getUserName();
    private static final String password = LoadMySQL.getPassword();

    public GetArray()
    {
        new LoadMySQL();
        Create_DataBase_With_Tables create = new Create_DataBase_With_Tables();
        try
        {
            Class.forName(jdbcDriver);
            Connection con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            try
            {
                new LoadMySQL();
                create.createUsersTable();
                create.createLocationsTable();
                create.createOrganisationsTable();
                create.createIDCardTable();
                create.createLocationCardTable();
                create.createDriversLicenseTable();
                create.createMessagesTable();
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
            create.createDatabase();
        }
    }
    @NotNull
    public static ArrayList<User> getDataFromUserTable()
    {
        try
        {
            Class.forName(jdbcDriver);
            Connection con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            ArrayList<User> users = new ArrayList<>();
            Statement st = con.createStatement();
            String sql = ("SELECT * FROM Users ORDER BY id DESC;");
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                int id = rs.getInt("id");
                String uname = rs.getString("uname");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String email = rs.getString("email");
                Date birthDate = rs.getDate("birthDate");
                String birthPlace = rs.getString("birthPlace");
                Sex sex = Sex.valueOf(rs.getString("sex"));
                int isActive = rs.getInt("isActive");
                int isMom = rs.getInt("isMom");
                String girlName = rs.getString("girlName");
                Nationality nationality = Nationality.valueOf(rs.getString("nationality"));
                //System.out.println(id+", "+uname+", "+userName+", "+password+", "+email+", "+birthDate.toString()+", "+birthPlace+", "+sex+", "+isActive+", "+isMom+", "+girlName+", "+nationality);
                boolean aktiv = false;
                boolean Mom = false;
                if(isActive==1) aktiv = true;
                if(isMom==1)Mom = true;
                users.add(new User(id,uname,userName,password,email,birthDate,birthPlace,sex,aktiv,Mom,girlName, nationality));
            }
            con.close();
            return users;
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }
    @NotNull
    public static ArrayList<ID_CARD> getDataFromIDCardTable()
    {
        try
        {
            Class.forName(jdbcDriver);
            Connection con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            ArrayList<ID_CARD> cards = new ArrayList<>();
            Statement st = con.createStatement();
            String sql = ("SELECT * FROM IDCard ORDER BY id DESC;");
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                int id = rs.getInt("id");
                int userid = rs.getInt("userid");
                String cardNumber = rs.getString("cardNumber");
                int cam = rs.getInt("can");
                int fingerprint = rs.getInt("fingerprint");
                int orgid = rs.getInt("orgid");
                Date expiration_date = rs.getDate("expirationDate");
                //System.out.println(country+", "+county+", "+city+", "+street+", "+rest+", "+house_number+", "+registration_date+", "+expiration_date);
                User user = GetObject.getUserById(userid);
                Nationality nationality = Objects.requireNonNull(user).getNationality();
                Organisation org = GetObject.getOrgannisationbyId(orgid);
                boolean finger = fingerprint == 1;
                cards.add(new ID_CARD(id,cam,user,org,cardNumber,finger,expiration_date,nationality));
            }
            con.close();
            return cards;
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    @NotNull
    public static ArrayList<Location> getDataFromLocationsTable()
    {
        try
        {
            Class.forName(jdbcDriver);
            Connection con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            ArrayList<Location> locations = new ArrayList<>();
            Statement st = con.createStatement();
            String sql = ("SELECT * FROM Locations ORDER BY id DESC;");
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                int id = rs.getInt("id");
                String country = rs.getString("country");
                String county = rs.getString("county");
                String city = rs.getString("city");
                String street = rs.getString("street");
                String rest = rs.getString("rest");
                int house_number = rs.getInt("houseNumber");
                Date registration_date = rs.getDate("registrationDate");
                Date expiration_date =null;
                if(rs.getDate("expirationdate")!=null)
                {
                    expiration_date = rs.getDate("expirationdate");
                }
                //System.out.println(country+", "+county+", "+city+", "+street+", "+rest+", "+house_number+", "+registration_date+", "+expiration_date);
                locations.add(new Location(id,country,county,city,street,house_number,rest,registration_date,expiration_date));
            }
            con.close();
            return locations;
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    @NotNull
    public static ArrayList<Organisation> getDataFromOrganisationsTable()
    {
        try
        {
            Class.forName(jdbcDriver);
            Connection con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            ArrayList<Organisation> organisations = new ArrayList<>();
            Statement st = con.createStatement();
            String sql = ("SELECT * FROM Organisations ORDER BY id DESC;");
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("oname");
                int locationid = rs.getInt("location");
                Nationality nationality = Nationality.valueOf(rs.getString("nationality"));
                Location location = GetObject.getLocationById(locationid);
                organisations.add(new Organisation(id,name,location,nationality));
            }
            con.close();
            return organisations;
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    @NotNull
    public static ArrayList<Location_CARD> getDataFromLocationCardTable()
    {
        try
        {
            Class.forName(jdbcDriver);
            Connection con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            ArrayList<Location_CARD> cards = new ArrayList<>();
            Statement st = con.createStatement();
            String sql = ("SELECT * FROM LocationCard ORDER BY id DESC;");
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("cardNumber");
                int dlocationid = rs.getInt("defaultlocation");
                int rlocationid;
                int orgid = rs.getInt("orgid");
                int userid = rs.getInt("userid");
                User user = GetObject.getUserById(userid);
                Location defaultlocation = GetObject.getLocationById(dlocationid);
                Organisation organisation = GetObject.getOrgannisationbyId(orgid);
                if(rs.getString("residentallocation")!=null)
                {
                    rlocationid = rs.getInt("residentallocation");
                    Location residentallocation = GetObject.getLocationById(rlocationid);
                    cards.add(new Location_CARD(id,name,defaultlocation,residentallocation,user,organisation));
                }
                else {
                    cards.add(new Location_CARD(id,name,defaultlocation,user,organisation));
                }
            }
            con.close();
            return cards;
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    @NotNull
    public static ArrayList<Drivers_License> getDataFromDriversLicenseTable()
    {
        try
        {
            Class.forName(jdbcDriver);
            Connection con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            ArrayList<Drivers_License> cards = new ArrayList<>();
            Statement st = con.createStatement();
            String sql = ("SELECT * FROM DriversLicense ORDER BY id DESC;");
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                int id = rs.getInt("id");
                String cardNumber = rs.getString("cardNumber");
                int userid = rs.getInt("uid");
                User user = GetObject.getUserById(userid);
                int orgid = rs.getInt("orgid");
                Organisation organisation = GetObject.getOrgannisationbyId(orgid);
                Date acquire = rs.getDate("acquireDate");
                Date expiration = rs.getDate("expirationDate");
                cards.add(new Drivers_License(id,user,cardNumber,expiration,acquire,organisation));
            }
            con.close();
            return cards;
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    public static ArrayList<Message> getDataFromMessagesTable()
    {
        try
        {
            Class.forName(jdbcDriver);
            Connection con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            ArrayList<Message> messages = new ArrayList<>();
            Statement st = con.createStatement();
            String sql = ("SELECT * FROM Messages ORDER BY id DESC;");
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                int id = rs.getInt("id");
                String Subject = rs.getString("Subject");
                String content = rs.getString("message");
                int userid = rs.getInt("uid");
                User user = GetObject.getUserById(userid);
                int orgid = rs.getInt("orgid");
                Organisation organisation = GetObject.getOrgannisationbyId(orgid);
                Date arriveTime = rs.getDate("arriveTime");
                Date deadline = rs.getDate("deadline");
                int isRead =rs.getInt("isRead");
                boolean Read = isRead == 1;
                int givenDocs =rs.getInt("hasDocs");
                boolean Docs = givenDocs == 1;
                messages.add(new Message(id,user,organisation,Subject,content,deadline,arriveTime,Read,Docs));
            }
            con.close();
            return messages;
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    @NotNull
    public static ArrayList<Object> getData(String Username, String MD5Password) {
        ArrayList<Object> objects = new ArrayList<>();
        User user = GetObject.getUserUserName(Username,MD5Password);
        objects.add(user);
        ID_CARD id_card = GetObject.getID_CARDByUserid(Objects.requireNonNull(user).getId());
        objects.add(id_card);
        Location_CARD location_card = GetObject.getLocation_CARDByUserid(user.getId());
        objects.add(location_card);
        Drivers_License drivers_license = GetObject.getDriversLicenseByUserid(user.getId());
        objects.add(drivers_license);
        return objects;
    }
}

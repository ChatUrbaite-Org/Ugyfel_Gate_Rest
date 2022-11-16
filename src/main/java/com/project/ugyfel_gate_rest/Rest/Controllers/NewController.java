package com.project.ugyfel_gate_rest.Rest.Controllers;

import com.project.ugyfel_gate_rest.Classes.*;
import com.project.ugyfel_gate_rest.DataBase.Insert_Into_DataBase;
import com.project.ugyfel_gate_rest.Enums.Nationality;
import com.project.ugyfel_gate_rest.Rest.NewService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.Arrays;
import java.util.Objects;

import static com.project.ugyfel_gate_rest.DataBase.GetObject.*;
import static com.project.ugyfel_gate_rest.DataBase.GetObject.getOrgannisationbyId;
import static java.sql.Date.*;

@Path("/new")
public class NewController implements NewService
{
    Insert_Into_DataBase insert = new Insert_Into_DataBase();
    @Path("/user")
    @Override
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createNewUser(@HeaderParam("uname") String name,
                                  @HeaderParam("userName") String username,
                                  @HeaderParam("email") String email,
                                  @HeaderParam("token") String token,
                                  @HeaderParam("birthPlace") String birthPlace,
                                  @HeaderParam("birthDate") String birthDate,
                                  @HeaderParam("sex") String sex,
                                  @HeaderParam("isMom") String isMom,
                                  @HeaderParam("girlName") String girlName,
                                  @HeaderParam("nationality") String nationality)
    {
        boolean mom = false;
        if(Objects.equals(isMom, "true")) mom = true;
        try
        {
            insert.insertIntoUserTable(new User(name,username,token,email, valueOf(birthDate),birthPlace,sex,true,mom,girlName,nationality));
            return Response.status(Response.Status.CREATED).type(MediaType.APPLICATION_JSON).build();
        }
        catch (Exception ex)
        {
            JSONObject object = new JSONObject();
            try {
                object.put("Name",name);
                object.put("UserName",username);
                object.put("Email",email);
                object.put("Token",token);
                object.put("BirthPlace",birthPlace);
                object.put("Birth Date",birthDate);
                object.put("SEX",sex);
                object.put("MoM",isMom);
                object.put("GirlName",girlName);
                object.put("Nationality",nationality);
                object.put("Message",ex.getMessage());
                object.put("StackTraceToString", Arrays.toString(ex.getStackTrace()));
                object.put("StackTrace",ex.getStackTrace());
                object.put("Cause",ex.getCause());
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

            return Response.ok(object).type(MediaType.APPLICATION_JSON).build();
        }

    }
    @Path("/DLocation")
    @Override
    @POST
    public Response createNewDLocation(@HeaderParam("country") String country,
                                       @HeaderParam("county") String county,
                                       @HeaderParam("city") String city,
                                       @HeaderParam("street") String street,
                                       @HeaderParam("house_number") String house_number,
                                       @HeaderParam("registrationDate") String registration_date,
                                       @HeaderParam("rest") String rest)
    {
        try
        {
            insert.insertIntoLocationsTable(new Location(country,county,city,street,Integer.parseInt(house_number),rest,valueOf(registration_date)));
            return Response.status(Response.Status.CREATED).type(MediaType.APPLICATION_JSON).build();
        }
        catch (Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).build();
        }

    }
    @Path("/RLocation")
    @Override
    @POST
    public Response createNewRLocation(@HeaderParam("country") String country,
                                       @HeaderParam("county") String county,
                                       @HeaderParam("city") String city,
                                       @HeaderParam("street") String street,
                                       @HeaderParam("houseNumber") String house_number,
                                       @HeaderParam("registrationDate") String registration_date,
                                       @HeaderParam("expirationDate") String expiration_date,
                                       @HeaderParam("rest") String rest)
    {
        try
        {
            insert.insertIntoLocationsTable(new Location(country,county,city,street,Integer.parseInt(house_number),rest,valueOf(expiration_date),valueOf(registration_date)));
            return Response.status(Response.Status.CREATED).type(MediaType.APPLICATION_JSON).build();
        }
        catch (Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).build();
        }

    }
    @Path("/Organisation")
    @Override
    @POST
    public Response createNewOrganisation(@HeaderParam("name") String name,
                                          @HeaderParam("locid") String locid,
                                          @HeaderParam("nationality") String nationality)
    {
        try
        {
            insert.insertIntoOrganisationsTable(new Organisation(name, getLocationById(Integer.parseInt(locid)), Nationality.valueOf(nationality)));
            return Response.status(Response.Status.CREATED).type(MediaType.APPLICATION_JSON).build();
        }
        catch (Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).build();
        }

    }
    @Path("/IDCard")
    @Override
    @POST
    public Response createNewIDCard(@HeaderParam("can_number") String can_number,
                                    @HeaderParam("userid") String userid,
                                    @HeaderParam("organid") String organid,
                                    @HeaderParam("idNum") String idNum,
                                    @HeaderParam("fingerPrint") String fingerPrint,
                                    @HeaderParam("expiry") String Expiry,
                                    @HeaderParam("nationality") String nation)
    {
        try
        {
            insert.insertIntoIDCardTable(new ID_CARD(Integer.parseInt(can_number), getUserById(Integer.parseInt(userid)), getOrgannisationbyId(Integer.parseInt(organid)),idNum,Boolean.parseBoolean(fingerPrint),valueOf(Expiry), Nationality.valueOf(nation)));
            return Response.status(Response.Status.CREATED).type(MediaType.APPLICATION_JSON).build();
        }
        catch (Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).build();
        }

    }
    @Path("/LocationCard")
    @Override
    @POST
    public Response createLocationCard(@HeaderParam("loc_Id") String loc_Id,
                                       @HeaderParam("userid") String userid,
                                       @HeaderParam("defaultlocation") String defaultlocation,
                                       @HeaderParam("organid") String organid)
    {
        try
        {
            insert.insertIntoLocationCardTable(new Location_CARD(loc_Id, getLocationById(Integer.parseInt(defaultlocation)), getUserById(Integer.parseInt(userid)), getOrgannisationbyId(Integer.parseInt(organid))));
            return Response.status(Response.Status.CREATED).type(MediaType.APPLICATION_JSON).build();
        }
        catch (Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).build();
        }

    }
    @Path("/LocationCardw")
    @Override
    @POST
    public Response createLocationCardw(@HeaderParam("loc_Id") String loc_Id,
                                        @HeaderParam("userid") String userid,
                                        @HeaderParam("defaultlocation") String defaultlocation,
                                        @HeaderParam("residentallocation") String residentallocation,
                                        @HeaderParam("organid") String organid)
    {
        try
        {
            insert.insertIntoLocationCardTable(new Location_CARD(loc_Id, getLocationById(Integer.parseInt(defaultlocation)), getLocationById(Integer.parseInt(residentallocation)), getUserById(Integer.parseInt(userid)), getOrgannisationbyId(Integer.parseInt(organid))));
            return Response.status(Response.Status.CREATED).type(MediaType.APPLICATION_JSON).build();
        }
        catch (Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).build();
        }

    }
    @Path("/DriversLicense")
    @Override
    @POST
    public Response createDriversLicense(@HeaderParam("loc_Id") String card_number,
                                         @HeaderParam("userid") String userid,
                                         @HeaderParam("expiry") String expiry,
                                         @HeaderParam("acquire") String acquire,
                                         @HeaderParam("organid") String organid)
    {
        try
        {
            insert.insertIntoDriversLicenseTable(new Drivers_License(getUserById(Integer.parseInt(userid)),card_number,valueOf(expiry),valueOf(acquire),getOrgannisationbyId(Integer.parseInt(organid))));
            return Response.status(Response.Status.CREATED).type(MediaType.APPLICATION_JSON).build();
        }
        catch (Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).build();
        }

    }
    @Path("/Message")
    @Override
    @POST
    public Response createMessage(@HeaderParam("subject") String subject,
                                  @HeaderParam("message") String message,
                                  @HeaderParam("userid") String userid,
                                  @HeaderParam("arriveTime") String arriveTime,
                                  @HeaderParam("deadline") String deadline,
                                  @HeaderParam("documents") String documents,
                                  @HeaderParam("organid") String organid)
    {
        try
        {
            insert.insertIntoMessagesTable(new Message(getUserById(Integer.parseInt(userid)),getOrgannisationbyId(Integer.parseInt(organid)),subject,message,valueOf(arriveTime),valueOf(deadline),false,Boolean.parseBoolean(documents)));
            return Response.status(Response.Status.CREATED).type(MediaType.APPLICATION_JSON).build();
        }
        catch (Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).build();
        }

    }
}

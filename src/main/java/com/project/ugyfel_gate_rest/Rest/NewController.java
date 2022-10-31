package com.project.ugyfel_gate_rest.Rest;

import com.project.ugyfel_gate_rest.Classes.*;
import com.project.ugyfel_gate_rest.DataBase.Insert_Into_DataBase;
import com.project.ugyfel_gate_rest.Enums.Nationality;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

import static com.project.ugyfel_gate_rest.DataBase.GetObject.*;
import static com.project.ugyfel_gate_rest.DataBase.GetObject.getOrgannisationbyId;
@Path("/new")
public class NewController implements NewService
{
    Insert_Into_DataBase insert = new Insert_Into_DataBase();
    @Path("/user")
    @Override
    @GET
    public Response createNewUser(@HeaderParam("name") String name,
                                  @HeaderParam("userName") String username,
                                  @HeaderParam("email") String email,
                                  @HeaderParam("token") String token,
                                  @HeaderParam("birthPlace") String birthPlace,
                                  @HeaderParam("birthDate") Date birthDate,
                                  @HeaderParam("sex") String sex,
                                  @HeaderParam("isMom") boolean isMom,
                                  @HeaderParam("girlName") String girlName,
                                  @HeaderParam("natinality") String nationality)
    {
        try
        {
            insert.insertIntoUserTable(new User(name,username,token,email,birthDate,birthPlace,sex,true,isMom,girlName,nationality));
            return Response.status(Response.Status.CREATED).type(MediaType.APPLICATION_JSON).build();
        }
        catch (Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).build();
        }

    }
    @Path("/DLocation")
    @Override
    @GET
    public Response createNewDLocation(@HeaderParam("country") String country,
                                       @HeaderParam("county") String county,
                                       @HeaderParam("city") String city,
                                       @HeaderParam("street") String street,
                                       @HeaderParam("house_number") int house_number,
                                       @HeaderParam("registrationDate") Date registration_date,
                                       @HeaderParam("rest") String rest)
    {
        try
        {
            insert.insertIntoLocationsTable(new Location(country,county,city,street,house_number,rest,registration_date));
            return Response.status(Response.Status.CREATED).type(MediaType.APPLICATION_JSON).build();
        }
        catch (Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).build();
        }

    }
    @Path("/RLocation")
    @Override
    @GET
    public Response createNewRLocation(@HeaderParam("country") String country,
                                       @HeaderParam("county") String county,
                                       @HeaderParam("city") String city,
                                       @HeaderParam("street") String street,
                                       @HeaderParam("houseNumber") int house_number,
                                       @HeaderParam("registrationDate") Date registration_date,
                                       @HeaderParam("expirationDate") Date expiration_date,
                                       @HeaderParam("rest") String rest)
    {
        try
        {
            insert.insertIntoLocationsTable(new Location(country,county,city,street,house_number,rest,expiration_date,registration_date));
            return Response.status(Response.Status.CREATED).type(MediaType.APPLICATION_JSON).build();
        }
        catch (Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).build();
        }

    }
    @Path("/Organisation")
    @Override
    @GET
    public Response createNewOrganisation(@HeaderParam("name") String name,
                                          @HeaderParam("locid") int locid,
                                          @HeaderParam("nationality") String nationality)
    {
        try
        {
            insert.insertIntoOrganisationsTable(new Organisation(name, getLocationById(locid), Nationality.valueOf(nationality)));
            return Response.status(Response.Status.CREATED).type(MediaType.APPLICATION_JSON).build();
        }
        catch (Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).build();
        }

    }
    @Path("/IDCard")
    @Override
    @GET
    public Response createNewIDCard(@HeaderParam("can_number") int can_number,
                                    @HeaderParam("userid") int userid,
                                    @HeaderParam("organid") int organid,
                                    @HeaderParam("idNum") String idNum,
                                    @HeaderParam("fingerPrint") boolean fingerPrint,
                                    @HeaderParam("expiry") Date Expiry,
                                    @HeaderParam("nationality") String nation)
    {
        try
        {
            insert.insertIntoIDCardTable(new ID_CARD(can_number, getUserById(userid), getOrgannisationbyId(organid),idNum,fingerPrint,Expiry, Nationality.valueOf(nation)));
            return Response.status(Response.Status.CREATED).type(MediaType.APPLICATION_JSON).build();
        }
        catch (Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).build();
        }

    }
    @Path("/LocationCard")
    @Override
    @GET
    public Response createLocationCard(@HeaderParam("loc_Id") String loc_Id,
                                       @HeaderParam("userid") int userid,
                                       @HeaderParam("defaultlocation") int defaultlocation,
                                       @HeaderParam("organid") int organid)
    {
        try
        {
            insert.insertIntoLocationCardTable(new Location_CARD(loc_Id, getLocationById(defaultlocation), getUserById(userid), getOrgannisationbyId(organid)));
            return Response.status(Response.Status.CREATED).type(MediaType.APPLICATION_JSON).build();
        }
        catch (Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).build();
        }

    }
    @Path("/LocationCardw")
    @Override
    @GET
    public Response createLocationCardw(@HeaderParam("loc_Id") String loc_Id,
                                        @HeaderParam("userid") int userid,
                                        @HeaderParam("defaultlocation") int defaultlocation,
                                        @HeaderParam("residentallocation") int residentallocation,
                                        @HeaderParam("organid") int organid)
    {
        try
        {
            insert.insertIntoLocationCardTable(new Location_CARD(loc_Id, getLocationById(defaultlocation), getLocationById(residentallocation), getUserById(userid), getOrgannisationbyId(organid)));
            return Response.status(Response.Status.CREATED).type(MediaType.APPLICATION_JSON).build();
        }
        catch (Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).build();
        }

    }
    @Path("/DriversLicense")
    @Override
    @GET
    public Response createDriversLicense(@HeaderParam("loc_Id") String card_number,
                                         @HeaderParam("userid") int userid,
                                         @HeaderParam("expiry") Date expiry,
                                         @HeaderParam("acquire") Date acquire,
                                         @HeaderParam("organid") int organid)
    {
        try
        {
            insert.insertIntoDriversLicenseTable(new Drivers_License(getUserById(userid),card_number,expiry,acquire,getOrgannisationbyId(organid)));
            return Response.status(Response.Status.CREATED).type(MediaType.APPLICATION_JSON).build();
        }
        catch (Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).build();
        }

    }
    @Path("/Message")
    @Override
    @GET
    public Response createMessage(@HeaderParam("subject") String subject,
                                  @HeaderParam("message") String message,
                                  @HeaderParam("userid") int userid,
                                  @HeaderParam("arriveTime") Date arriveTime,
                                  @HeaderParam("deadline") Date deadline,
                                  @HeaderParam("documents") boolean documents,
                                  @HeaderParam("organid") int organid)
    {
        try
        {
            insert.insertIntoMessagesTable(new Message(getUserById(userid),getOrgannisationbyId(organid),subject,message,arriveTime,deadline,false,documents));
            return Response.status(Response.Status.CREATED).type(MediaType.APPLICATION_JSON).build();
        }
        catch (Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).build();
        }

    }
}

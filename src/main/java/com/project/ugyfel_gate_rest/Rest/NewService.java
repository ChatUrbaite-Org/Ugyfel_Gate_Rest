package com.project.ugyfel_gate_rest.Rest;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.Date;
//Path("/new") @POST
public interface NewService
{
    //Path("/user")
    Response createNewUser(@HeaderParam("uname") String name,
                           @HeaderParam("userName") String username,
                           @HeaderParam("email") String email,
                           @HeaderParam("token") String token,
                           @HeaderParam("birthPlace") String birthPlace,
                           @HeaderParam("birthDate") String birthDate,
                           @HeaderParam("sex") String sex,
                           @HeaderParam("isMom") String isMom,
                           @HeaderParam("girlName") String girlName,
                           @HeaderParam("natinality") String nationality);
    //Path("/DLocation")
    Response createNewDLocation(@HeaderParam("country") String country,
                                @HeaderParam("county") String county,
                                @HeaderParam("city") String city,
                                @HeaderParam("street") String street,
                                @HeaderParam("house_number") String house_number,
                                @HeaderParam("registrationDate") String registration_date,
                                @HeaderParam("rest") String rest);
    //Path("/RLocation")
    Response createNewRLocation(@HeaderParam("country") String country,
                                @HeaderParam("county") String county,
                                @HeaderParam("city") String city,
                                @HeaderParam("street") String street,
                                @HeaderParam("houseNumber") String house_number,
                                @HeaderParam("registrationDate") String registration_date,
                                @HeaderParam("expirationDate") String expiration_date,
                                @HeaderParam("rest") String rest);
    //Path("/Organisation")
    Response createNewOrganisation(@HeaderParam("name") String name,
                                   @HeaderParam("locid") String locid,
                                   @HeaderParam("nationality") String nationality);
    //Path("/IDCard")
    Response createNewIDCard(@HeaderParam("can_number") String can_number,
                             @HeaderParam("userid") String userid,
                             @HeaderParam("organid") String organid,
                             @HeaderParam("idNum") String idNum,
                             @HeaderParam("fingerPrint") String fingerPrint,
                             @HeaderParam("expiry") String Expiry,
                             @HeaderParam("nationality") String nation);
    //Path("/LocationCard")
    Response createLocationCard(@HeaderParam("loc_Id") String loc_Id,
                                @HeaderParam("userid") String userid,
                                @HeaderParam("defaultlocation") String defaultlocation,
                                @HeaderParam("organid") String organid);
    //Path("/LocationCard")
    Response createLocationCardw(@HeaderParam("loc_Id") String loc_Id,
                                 @HeaderParam("userid") String userid,
                                 @HeaderParam("defaultlocation") String defaultlocation,
                                 @HeaderParam("residentallocation") String residentallocation,
                                 @HeaderParam("organid") String organid);
    //Path("/DriversLicense")
    Response createDriversLicense(@HeaderParam("loc_Id") String card_number,
                                  @HeaderParam("userid") String userid,
                                  @HeaderParam("expiry") String expiry,
                                  @HeaderParam("acquire") String acquire,
                                  @HeaderParam("organid") String organid);
    //Path("/Message")
    Response createMessage(@HeaderParam("subject") String subject,
                           @HeaderParam("message") String message,
                           @HeaderParam("userid") String userid,
                           @HeaderParam("arriveTime") String arriveTime,
                           @HeaderParam("deadline") String deadline,
                           @HeaderParam("documents") String documents,
                           @HeaderParam("organid") String organid);
}

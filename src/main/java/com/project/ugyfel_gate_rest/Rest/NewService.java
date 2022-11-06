package com.project.ugyfel_gate_rest.Rest;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.Date;
//Path("/new") @POST
public interface NewService
{
    //Path("/user")
    Response createNewUser(@HeaderParam("Name") String name,
                           @HeaderParam("userName") String username,
                           @HeaderParam("email") String email,
                           @HeaderParam("token") String token,
                           @HeaderParam("birthPlace") String birthPlace,
                           @HeaderParam("birthDate") Date birthDate,
                           @HeaderParam("sex") String sex,
                           @HeaderParam("isMom") boolean isMom,
                           @HeaderParam("girlName") String girlName,
                           @HeaderParam("natinality") String nationality);
    //Path("/DLocation")
    Response createNewDLocation(@HeaderParam("country") String country,
                                @HeaderParam("county") String county,
                                @HeaderParam("city") String city,
                                @HeaderParam("street") String street,
                                @HeaderParam("house_number") int house_number,
                                @HeaderParam("registrationDate") Date registration_date,
                                @HeaderParam("rest") String rest);
    //Path("/RLocation")
    Response createNewRLocation(@HeaderParam("country") String country,
                                @HeaderParam("county") String county,
                                @HeaderParam("city") String city,
                                @HeaderParam("street") String street,
                                @HeaderParam("houseNumber") int house_number,
                                @HeaderParam("registrationDate") Date registration_date,
                                @HeaderParam("expirationDate") Date expiration_date,
                                @HeaderParam("rest") String rest);
    //Path("/Organisation")
    Response createNewOrganisation(@HeaderParam("name") String name,
                                   @HeaderParam("locid") int locid,
                                   @HeaderParam("nationality") String nationality);
    //Path("/IDCard")
    Response createNewIDCard(@HeaderParam("can_number") int can_number,
                             @HeaderParam("userid") int userid,
                             @HeaderParam("organid") int organid,
                             @HeaderParam("idNum") String idNum,
                             @HeaderParam("fingerPrint") boolean fingerPrint,
                             @HeaderParam("expiry") Date Expiry,
                             @HeaderParam("nationality") String nation);
    //Path("/LocationCard")
    Response createLocationCard(@HeaderParam("loc_Id") String loc_Id,
                                @HeaderParam("userid") int userid,
                                @HeaderParam("defaultlocation") int defaultlocation,
                                @HeaderParam("organid") int organid);
    //Path("/LocationCard")
    Response createLocationCardw(@HeaderParam("loc_Id") String loc_Id,
                                 @HeaderParam("userid") int userid,
                                 @HeaderParam("defaultlocation") int defaultlocation,
                                 @HeaderParam("residentallocation") int residentallocation,
                                 @HeaderParam("organid") int organid);
    //Path("/DriversLicense")
    Response createDriversLicense(@HeaderParam("loc_Id") String card_number,
                                  @HeaderParam("userid") int userid,
                                  @HeaderParam("expiry") Date expiry,
                                  @HeaderParam("acquire") Date acquire,
                                  @HeaderParam("organid") int organid);
    //Path("/Message")
    Response createMessage(@HeaderParam("subject") String subject,
                           @HeaderParam("message") String message,
                           @HeaderParam("userid") int userid,
                           @HeaderParam("arriveTime") Date arriveTime,
                           @HeaderParam("deadline") Date deadline,
                           @HeaderParam("documents") boolean documents,
                           @HeaderParam("organid") int organid);
}

package com.project.ugyfel_gate_rest;


import javax.ws.rs.HeaderParam;
import javax.ws.rs.core.Response;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public interface DataService
{
    Response getData(@HeaderParam("userName") String username, @HeaderParam("token") String token) throws NoSuchAlgorithmException;
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
    Response createNewDLocation(@HeaderParam("country") String country,
                                       @HeaderParam("county") String county,
                                       @HeaderParam("city") String city,
                                       @HeaderParam("street") String street,
                                       @HeaderParam("house_number") int house_number,
                                       @HeaderParam("registrationDate") Date registration_date,
                                       @HeaderParam("rest") String rest);
    Response createNewRLocation(@HeaderParam("country") String country,
                                       @HeaderParam("county") String county,
                                       @HeaderParam("city") String city,
                                       @HeaderParam("street") String street,
                                       @HeaderParam("houseNumber") int house_number,
                                       @HeaderParam("registrationDate") Date registration_date,
                                       @HeaderParam("expirationDate") Date expiration_date,
                                       @HeaderParam("rest") String rest);
    Response createNewOrganisation(@HeaderParam("name") String name,
                                          @HeaderParam("locid") int locid,
                                          @HeaderParam("nationality") String nationality);
    Response createNewIDCard(@HeaderParam("can_number") int can_number,
                                    @HeaderParam("userid") int userid,
                                    @HeaderParam("organid") int organid,
                                    @HeaderParam("idNum") String idNum,
                                    @HeaderParam("fingerPrint") boolean fingerPrint,
                                    @HeaderParam("expiry") Date Expiry,
                                    @HeaderParam("nationality") String nation);
    Response createLocationCard(@HeaderParam("loc_Id") String loc_Id,
                                       @HeaderParam("userid") int userid,
                                       @HeaderParam("defaultlocation") int defaultlocation,
                                       @HeaderParam("organid") int organid);
    Response createLocationCardw(@HeaderParam("loc_Id") String loc_Id,
                                        @HeaderParam("userid") int userid,
                                        @HeaderParam("defaultlocation") int defaultlocation,
                                        @HeaderParam("residentallocation") int residentallocation,
                                        @HeaderParam("organid") int organid);
    Response createDriversLicense(@HeaderParam("loc_Id") String card_number,
                                         @HeaderParam("userid") int userid,
                                         @HeaderParam("expiry") Date expiry,
                                         @HeaderParam("acquire") Date acquire,
                                         @HeaderParam("organid") int organid);
    Response createMessage(@HeaderParam("subject") String subject,
                                  @HeaderParam("message") String message,
                                  @HeaderParam("userid") int userid,
                                  @HeaderParam("arriveTime") Date arriveTime,
                                  @HeaderParam("deadline") Date deadline,
                                  @HeaderParam("documents") boolean documents,
                                  @HeaderParam("organid") int organid);
}


package com.project.ugyfel_gate_rest;


import javax.ws.rs.HeaderParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public interface DataService
{
    public Response getData(@HeaderParam("UserName") String username, @HeaderParam("Token") String token) throws NoSuchAlgorithmException;
    public Response createNewUser(@HeaderParam("Name") String name,
                                  @HeaderParam("UserName") String username,
                                  @HeaderParam("Email") String email,
                                  @HeaderParam("Token") String token,
                                  @HeaderParam("BirthPlace") String birthPlace,
                                  @HeaderParam("BirthDate") Date birthDate,
                                  @HeaderParam("Sex") String sex,
                                  @HeaderParam("isMom") boolean isMom,
                                  @HeaderParam("GirlName") String girlName,
                                  @HeaderParam("Natinality") String nationality);
    public Response createNewDLocation(@HeaderParam("country") String country,
                                       @HeaderParam("county") String county,
                                       @HeaderParam("city") String city,
                                       @HeaderParam("street") String street,
                                       @HeaderParam("house_number") int house_number,
                                       @HeaderParam("registrationDate") Date registration_date,
                                       @HeaderParam("rest") String rest);
    public Response createNewRLocation(@HeaderParam("country") String country,
                                       @HeaderParam("county") String county,
                                       @HeaderParam("city") String city,
                                       @HeaderParam("street") String street,
                                       @HeaderParam("houseNumber") int house_number,
                                       @HeaderParam("registrationDate") Date registration_date,
                                       @HeaderParam("expirationDate") Date expiration_date,
                                       @HeaderParam("rest") String rest);
    public Response createNewOrganisation(@HeaderParam("name") String name,
                                          @HeaderParam("locid") int locid,
                                          @HeaderParam("nationality") String nationality);
    public Response createNewIDCard(@HeaderParam("can_number") int can_number,
                                    @HeaderParam("userid") int userid,
                                    @HeaderParam("organid") int organid,
                                    @HeaderParam("idNum") String idNum,
                                    @HeaderParam("fingerPrint") boolean fingerPrint,
                                    @HeaderParam("expiry") Date Expiry,
                                    @HeaderParam("nationality") String nation);
    public Response createLocationCard(@HeaderParam("loc_Id") String loc_Id,
                                       @HeaderParam("userid") int userid,
                                       @HeaderParam("defaultlocation") int defaultlocation,
                                       @HeaderParam("organid") int organid);
    public Response createLocationCardw(@HeaderParam("loc_Id") String loc_Id,
                                        @HeaderParam("userid") int userid,
                                        @HeaderParam("defaultlocation") int defaultlocation,
                                        @HeaderParam("residentallocation") int residentallocation,
                                        @HeaderParam("organid") int organid);
    public Response createDriversLicense(@HeaderParam("loc_Id") String card_number,
                                         @HeaderParam("userid") int userid,
                                         @HeaderParam("expiry") Date expiry,
                                         @HeaderParam("acquire") Date acquire,
                                         @HeaderParam("organid") int organid);
    public Response createMessage(@HeaderParam("subject") String subject,
                                  @HeaderParam("message") String message,
                                  @HeaderParam("userid") int userid,
                                  @HeaderParam("arriveTime") Date arriveTime,
                                  @HeaderParam("deadline") Date deadline,
                                  @HeaderParam("documents") boolean documents,
                                  @HeaderParam("organid") int organid);
}


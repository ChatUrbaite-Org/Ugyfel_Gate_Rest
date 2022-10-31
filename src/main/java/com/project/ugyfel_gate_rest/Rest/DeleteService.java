package com.project.ugyfel_gate_rest.Rest;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
//Path("/delete")
public interface DeleteService
{
    //Path("/username")
    Response deleteUser(@HeaderParam("userName") String userName,
                               @HeaderParam("token") String token);
    //Path("/user")
    Response deleteUser(@HeaderParam("Userid") int userid);
    //Path("/location")
    Response deleteLocation(@HeaderParam("Locationid") int locid);
    //Path("/organisation")
    Response deleteOrganisation(@HeaderParam("Organisationid") int orgid);
    //Path("/IDCard")
    Response deleteIDCard(@HeaderParam("IDCardid") int IDCardid);
    //Path("/LocationCard")
    Response deleteLocationCard(@HeaderParam("LocationCardid") int LocationCardid);
    //Path("/DriversLicense")
    Response deleteDriversLicense(@HeaderParam("DriversLicenseid") int DriversLicense);
    //Path("/Message")
    Response deleteMessage(@HeaderParam("Messageid") int Messageid);
}

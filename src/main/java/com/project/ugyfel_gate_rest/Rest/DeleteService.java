package com.project.ugyfel_gate_rest.Rest;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.core.Response;

public interface DeleteService
{
    Response deleteUser(@HeaderParam("userName") String userName,
                               @HeaderParam("token") String token);
    Response deleteUser(@HeaderParam("Userid") int userid);
    Response deleteLocation(@HeaderParam("Locationid") int locid);
    Response deleteOrganisation(@HeaderParam("Organisationid") int orgid);
    Response deleteIDCard(@HeaderParam("IDCardid") int IDCardid);
    Response deleteLocationCard(@HeaderParam("LocationCardid") int LocationCardid);
    Response deleteDriversLicense(@HeaderParam("DriversLicenseid") int DriversLicense);
    Response deleteMessage(@HeaderParam("Messageid") int Messageid);
}

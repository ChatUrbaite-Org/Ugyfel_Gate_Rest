package com.project.ugyfel_gate_rest.Rest.Controllers;

import com.project.ugyfel_gate_rest.DataBase.DeleteData;
import com.project.ugyfel_gate_rest.DataBase.GetId;
import com.project.ugyfel_gate_rest.DataBase.GetObject;
import com.project.ugyfel_gate_rest.Rest.DeleteService;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/delete")
public class DeleteController implements DeleteService
{
    @Path("/username")
    @Override
    public Response deleteUser(@HeaderParam("userName") String userName,
                               @HeaderParam("token") String token)
    {
        try{
            DeleteData.deleteUser(GetId.getUserId(GetObject.getUserUserName(userName,token)));
            return Response.ok().build();
        }catch (Exception e)
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }
    @Path("/user")
    @Override
    public Response deleteUser(@HeaderParam("Userid") int userid)
    {
        try{
            DeleteData.deleteLocation(userid);
            return Response.ok().build();
        }catch (Exception e)
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    @Path("/location")
    @Override
    public Response deleteLocation(@HeaderParam("Locationid") int locid)
    {
        try{
            DeleteData.deleteLocation(locid);
            return Response.ok().build();
        }catch (Exception e)
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    @Path("/organisation")
    @Override
    public Response deleteOrganisation(@HeaderParam("Organisationid") int orgid)
    {
        try{
            DeleteData.deleteOrganisation(orgid);
            return Response.ok().build();
        }catch (Exception e)
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    @Path("/IDCard")
    @Override
    public Response deleteIDCard(@HeaderParam("IDCardid") int IDCardid)
    {
        try{
            DeleteData.deleteIDCard(IDCardid);
            return Response.ok().build();
        }catch (Exception e)
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    @Path("/LocationCard")
    @Override
    public Response deleteLocationCard(@HeaderParam("LocationCardid") int LocationCardid)
    {
        try{
            DeleteData.deleteLocationCard(LocationCardid);
            return Response.ok().build();
        }catch (Exception e)
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    @Path("/DriversLicense")
    @Override
    public Response deleteDriversLicense(@HeaderParam("DriversLicenseid") int DriversLicenseid)
    {
        try{
            DeleteData.deleteDriversLicense(DriversLicenseid);
            return Response.ok().build();
        }catch (Exception e)
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    @Path("/Message")
    @Override
    public Response deleteMessage(@HeaderParam("Messageid") int Messageid)
    {
        try{
            DeleteData.deleteMessage(Messageid);
            return Response.ok().build();
        }catch (Exception e)
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}

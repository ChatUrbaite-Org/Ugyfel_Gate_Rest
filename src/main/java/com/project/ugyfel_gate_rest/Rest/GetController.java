package com.project.ugyfel_gate_rest.Rest;

import com.project.ugyfel_gate_rest.Classes.Location;
import com.project.ugyfel_gate_rest.Classes.Organisation;
import com.project.ugyfel_gate_rest.Classes.User;
import com.project.ugyfel_gate_rest.DataBase.GetArray;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static com.project.ugyfel_gate_rest.DataBase.GetObject.getUser;


@Path("/get")
public class GetController implements GetService
{

    @Override
    @Path("/user")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes ("application/c-www-form-urlencoded")
    public Response getUserData(@HeaderParam("userName") String username, @HeaderParam("token") String token) {
        JSONObject resp = new JSONObject();
        resp.put("Username",username);
        resp.put("Token",token);

        if(!token.equals("") && (getUser(username, token) != null))
        {
            //resp.put("Data", GetJSON.getJSONData("JaniHegedus",MD5.Translate_to_MD5_HASH("Jancsika20"))); //testData
            resp.put("Data", GetJSON.getJSONData(username,token));
            return Response.ok(resp.toString()).type(MediaType.APPLICATION_JSON).build();
        }
        else
        {
            resp.put("error","No Token");
        }
        //
        resp.put("Data", GetJSON.getJSONData(username,token));
        return Response.status(Response.Status.UNAUTHORIZED).type(MediaType.APPLICATION_JSON).entity(resp).build();
    }
    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes ("application/c-www-form-urlencoded")
    @Path("/users")
    public Response getUsers()
    {
        for(User user : GetArray.getDataFromUserTable())
        {
            return Response.ok(GetJSON.getJSONUser(user).toString()).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes ("application/c-www-form-urlencoded")
    @Path("/locations")
    public Response getLocations()
    {
        for(Location user : GetArray.getDataFromLocationsTable())
        {
            return Response.ok(GetJSON.getJSONDLocation(user).toString()).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes ("application/c-www-form-urlencoded")
    @Path("/organisations")
    public Response getOrganisations()
    {
        for(Organisation org : GetArray.getDataFromOrganisationsTable())
        {
            return Response.ok(GetJSON.getJSONORG(org).toString()).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes ("application/c-www-form-urlencoded")
    @Path("/idcards")
    public Response getIdCards()
    {
        for(User user : GetArray.getDataFromUserTable())
        {
            return Response.ok(GetJSON.getJSONIDCard(user).toString()).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes ("application/c-www-form-urlencoded")
    @Path("/locationcards")
    public Response getLocationCards()
    {
        for(User user : GetArray.getDataFromUserTable())
        {
            return Response.ok(GetJSON.getJSONLocationCard(user).toString()).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes ("application/c-www-form-urlencoded")
    @Path("/driverslicenses")
    public Response getDriversLicenses()
    {
        for(User user : GetArray.getDataFromUserTable())
        {
            return Response.ok(GetJSON.getJSONDriversLicense(user).toString()).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
}
package com.project.ugyfel_gate_rest.Rest.Controllers;

import com.project.ugyfel_gate_rest.DataBase.GetJSON;
import com.project.ugyfel_gate_rest.Rest.GetService;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static com.project.ugyfel_gate_rest.DataBase.GetJSON.*;
import static com.project.ugyfel_gate_rest.DataBase.GetObject.getUserEmail;
import static com.project.ugyfel_gate_rest.DataBase.GetObject.getUserUserName;


@Path("/get")
public class GetController implements GetService
{

    @Override
    @Path("/usern")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserData(@HeaderParam("userName") String username, @HeaderParam("token") String token) {
        JSONObject resp = new JSONObject();
        resp.put("Username",username);
        resp.put("Token",token);

        if(!token.equals("") && (getUserUserName(username, token) != null))
        {
            //resp.put("Data", GetJSON.getJSONData("JaniHegedus",MD5.Translate_to_MD5_HASH("Jancsika20"))); //testData
            resp.put("Data", GetJSON.getJSONDataUserName(username,token));
            return Response.ok(resp.toString()).type(MediaType.APPLICATION_JSON).build();
        }
        else
        {
            resp.put("error","No Token");
        }
        //
        resp.put("Data", GetJSON.getJSONDataUserName(username,token));
        return Response.status(Response.Status.UNAUTHORIZED).type(MediaType.APPLICATION_JSON).entity(resp).build();
    }
    @Override
    @Path("/usere")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserDataEmail(@HeaderParam("Email") String email, @HeaderParam("token") String token) {
        JSONObject resp = new JSONObject();
        resp.put("Username",email);
        resp.put("Token",token);

        if(!token.equals("") && (getUserEmail(email, token) != null))
        {
            //resp.put("Data", GetJSON.getJSONData("JaniHegedus",MD5.Translate_to_MD5_HASH("Jancsika20"))); //testData
            resp.put("Data", GetJSON.getJSONDataUserName(email,token));
            return Response.ok(resp.toString()).type(MediaType.APPLICATION_JSON).build();
        }
        else
        {
            resp.put("error","No Token");
        }
        //
        resp.put("Data", GetJSON.getJSONDataUserName(email,token));
        return Response.status(Response.Status.UNAUTHORIZED).type(MediaType.APPLICATION_JSON).entity(resp).build();
    }
    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/users")
    public Response getUsers()
    {
        return Response.ok(getJSONUsers().toString()).type(MediaType.APPLICATION_JSON).build();
    }
    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/locations")
    public Response getLocations()
    {
        return Response.ok(getJSONLocations().toString()).type(MediaType.APPLICATION_JSON).build();
    }
    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/organisations")
    public Response getOrganisations()
    {

        return Response.ok(getJSONOrganisation().toString()).type(MediaType.APPLICATION_JSON).build();
    }
    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/idcards")
    public Response getIdCards()
    {

        return Response.ok(getJSONIDCards().toString()).type(MediaType.APPLICATION_JSON).build();
    }
    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/locationcards")
    public Response getLocationCards()
    {

        return Response.ok(getJSONLocationCards().toString()).type(MediaType.APPLICATION_JSON).build();
    }
    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/driverslicenses")
    public Response getDriversLicenses()
    {

        return Response.ok(getJSONDriversLicenses().toString()).type(MediaType.APPLICATION_JSON).build();
    }
    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/messages")
    public Response getMessages()
    {

        return Response.ok(GetJSON.getJSONMessages().toString()).type(MediaType.APPLICATION_JSON).build();
    }
}
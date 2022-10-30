package com.project.ugyfel_gate_rest;

import com.project.ugyfel_gate_rest.Classes.Token;
import com.project.ugyfel_gate_rest.DataBase.GetObject;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;


@Path("/person")
public class Data implements DataService
{


    @Path("/get")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes ("application/c-www-form-urlencoded")
    public Response getData(@HeaderParam("UserName") String username, @HeaderParam("Token") String token) throws NoSuchAlgorithmException
    {
        JSONObject resp = new JSONObject();
        resp.put("Username",username);
        resp.put("Token",token);

        if(!token.equals("") && (GetObject.getUser(username, token) != null))
        {
            //resp.put("Data", GetJSON.getJSONData("JaniHegedus",MD5.Translate_to_MD5_HASH("Jancsika20")));
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
    public String toString()
    {
        return "Hello";
    }

    @GET
    @Path("doTask/task")
    @Produces(MediaType.APPLICATION_JSON)
    public Response doTask(@QueryParam("task") String task){
        //List<Ticket> ticketek = new ArrayList<>();
        //JSONObject t1 = new JSONObject(new Ticket("Nem megy a ventillátor", RegisterEnum.User));
        //JSONObject t2 = new JSONObject(new Ticket("Nem megy a vonat", RegisterEnum.Admin));
        JSONArray tickets = new JSONArray();
        //tickets.put(t1);
        //tickets.put(t2);
        return Response.ok(tickets.toString()).build();
    }
    public Response sendRecieveDemoData(Object o)
    {
        return null;
    }
}
package com.project.ugyfel_gate_rest.Rest;


import javax.ws.rs.*;
import javax.ws.rs.core.*;
//Path("/get")
public interface GetService
{
    //Path("/usern")
    Response getUserData(@HeaderParam("userName") String username, @HeaderParam("token") String token);
    //Path("/usere")
    Response getUserDataEmail(@HeaderParam("Email") String email, @HeaderParam("token") String token);
    //Path("/users")
    Response getUsers();
    //Path("/locations")
    Response getLocations();
    //Path("/organisations")
    Response getOrganisations();
    //Path("/idcards")
    Response getIdCards();
    //Path("/locationcards")
    Response getLocationCards();
    //Path("/driverslicenses")
    Response getDriversLicenses();
}


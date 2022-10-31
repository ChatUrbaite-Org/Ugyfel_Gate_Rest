package com.project.ugyfel_gate_rest.Rest;


import javax.ws.rs.HeaderParam;
import javax.ws.rs.core.Response;

public interface GetService
{
    Response getUserData(@HeaderParam("userName") String username, @HeaderParam("token") String token);
    Response getUserDataEmail(@HeaderParam("Email") String email, @HeaderParam("token") String token);
    Response getUsers();
    Response getLocations();
    Response getOrganisations();
    Response getIdCards();
    Response getLocationCards();
    Response getDriversLicenses();
}


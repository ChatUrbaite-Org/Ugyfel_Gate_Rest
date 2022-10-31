package com.project.ugyfel_gate_rest.Rest;


import javax.ws.rs.HeaderParam;
import javax.ws.rs.core.Response;
import java.security.NoSuchAlgorithmException;

public interface GetService
{
    Response getUserData(@HeaderParam("userName") String username, @HeaderParam("token") String token) throws NoSuchAlgorithmException;
    Response getUsers();
    Response getLocations();
    Response getOrganisations();
    Response getIdCards();
    Response getLocationCards();
    Response getDriversLicenses();
}


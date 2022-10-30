package com.project.ugyfel_gate_rest;


import javax.ws.rs.HeaderParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.security.NoSuchAlgorithmException;

public interface DataService
{
    public Response getData(@HeaderParam("UserName") String username, @HeaderParam("Token") String token) throws NoSuchAlgorithmException;
    public Response doTask(@QueryParam("task") String task);
}


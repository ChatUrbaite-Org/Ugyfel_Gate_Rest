package com.project.ugyfel_gate_rest.DataBase;

import com.project.ugyfel_gate_rest.Classes.*;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Objects;

import static com.project.ugyfel_gate_rest.DataBase.GetArray.*;


public class GetObject
{
    @Nullable
    public static Organisation getOrgannisationbyId(int orgid)
    {
        ArrayList<Organisation> orgs = getDataFromOrganisationsTable();
        for (Organisation org : orgs)
        {
            if(org.getId()==orgid)
            {
                return org;
            }
        }
        return null;
    }
    @Nullable
    public static User getUserById(int id)
    {
        ArrayList<User> users = getDataFromUserTable();
        for (User user : users)
        {
            if(user.getId()==id)
            {
                return user;
            }
        }
        return null;
    }
    @Nullable
    public static Location getLocationById(int locationid)
    {
        ArrayList<Location> locations = getDataFromLocationsTable();
        for (Location location : locations)
        {
            if(location.getId()==locationid)
            {
                return location;
            }
        }
        return null;
    }
    @Nullable
    public static User getUserUserName(String UserName, String MD5Password)
    {
        ArrayList<User> users = getDataFromUserTable();
        for (User user : users)
        {
            if(Objects.equals(user.getUsername(), UserName)
                    && Objects.equals(user.getPassword(), MD5Password))
            {
                return user;
            }
        }
        return null;
    }
    @Nullable
    public static User getUserEmail(String Email, String MD5Password)
    {
        ArrayList<User> users = getDataFromUserTable();
        for (User user : users)
        {
            if(Objects.equals(user.getEmail(), Email)
                    && Objects.equals(user.getPassword(), MD5Password))
            {
                return user;
            }
        }
        return null;
    }
    @Nullable
    public static Location_CARD getLocation_CARDByUserid(int id)
    {
        ArrayList<Location_CARD> location_cards = getDataFromLocationCardTable();
        for (Location_CARD location_card : location_cards)
        {
            if(Objects.equals(location_card.getUser().getId(), id))
            {
                return location_card;
            }
        }
        return null;
    }
    @Nullable
    public static Drivers_License getDriversLicenseByUserid(int userid)
    {
        ArrayList<Drivers_License> drivers_licenses = getDataFromDriversLicenseTable();
        for (Drivers_License drivers_license : drivers_licenses)
        {
            if(Objects.equals(drivers_license.getUser().getId(), userid))
            {
                return drivers_license;
            }
        }
        return null;
    }
    @Nullable
    public static ID_CARD getID_CARDByUserid(int id)
    {
        ArrayList<ID_CARD> id_cards = getDataFromIDCardTable();
        for (ID_CARD id_card : id_cards)
        {
            if(Objects.equals(id_card.getUser().getId(), id))
            {
                return id_card;
            }
        }
        return null;
    }

    public static @Nullable Message getMessageByUserid(int userid)
    {
        ArrayList<Message> id_cards = getDataFromMessagesTable();
        for (Message message : id_cards)
        {
            if(Objects.equals(message.getUser().getId(), userid))
            {
                return message;
            }
        }
        return null;
    }
}

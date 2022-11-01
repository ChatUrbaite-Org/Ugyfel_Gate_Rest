package com.project.ugyfel_gate_rest.DataBase;

import com.project.ugyfel_gate_rest.Classes.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Objects;

public class GetJSON
{
    public static @NotNull JSONObject getJSONUser(@NotNull User user)
    {
        JSONObject usero = new JSONObject();

        usero.put("id",Objects.requireNonNull(user).getId());
        usero.put("Name", user.getName());
        usero.put("Girl Name",user.getGirlName());
        usero.put("Email",user.getEmail());
        usero.put("User Name",user.getUsername());
        usero.put("Token",user.getPassword());
        usero.put("Birth Date",user.getBirthdate());
        usero.put("Sex",user.getSex());
        usero.put("Is Mom",user.isMom());
        usero.put("Nationality",user.getNationality());
        usero.put("Active",user.isActive());
        return usero;
    }
    public static @NotNull JSONObject getJSONIDCard(@NotNull User user)
    {
        ID_CARD id_card = GetObject.getID_CARDByUserid(user.getId());
        JSONObject id_cardO = new JSONObject();
        id_cardO.put("id",Objects.requireNonNull(id_card).getId());
        id_cardO.put("Number", Objects.requireNonNull(id_card).getId_num());
        id_cardO.put("CAN Number",id_card.getCAN_number());
        id_cardO.put("From Date",id_card.getExpiry());
        id_cardO.put("Organisation",getJSONORG(id_card.getOrgan()));
        return id_cardO;
    }
    public static @NotNull JSONObject getJSONLocationCard(@NotNull User user)
    {
        Location_CARD location_card = GetObject.getLocation_CARDByUserid(user.getId());
        JSONObject location_cardO= new JSONObject();
        if(location_card!=null)
        {
            location_cardO.put("id", Objects.requireNonNull(location_card).getId());
            location_cardO.put("Location Card ID", Objects.requireNonNull(location_card).getLoc_Id());
            location_cardO.put("Default Location",getJSONDLocation(Objects.requireNonNull(location_card).getDefaultlocation()));
            if(location_card.getResidentallocation() != null)
            {
                location_cardO.put("Residental Location",getJSONRLocation(location_card.getResidentallocation()));
            }
            else location_cardO.put("Residental Location","");
            location_cardO.put("Organisation",getJSONORG(location_card.getOrganisation()));

        }
        return location_cardO;
    }
    public static @NotNull JSONObject getJSONDriversLicense(@NotNull User user)
    {
        Drivers_License driversLicense = GetObject.getDriversLicenseByUserid(user.getId());
        JSONObject driversLicenseO = new JSONObject();
        if(driversLicense!=null)
        {
            driversLicenseO.put("id",Objects.requireNonNull(driversLicense).getId());
            driversLicenseO.put("Card Number", Objects.requireNonNull(driversLicense).getCard_number());
            driversLicenseO.put("Acquire Date",driversLicense.getAcquire());
            driversLicenseO.put("Expiry Date",driversLicense.getExpiry());
            driversLicenseO.put("Organisation",getJSONORG(driversLicense.getOrgan()));

        }
        return driversLicenseO;
    }

    public static @NotNull JSONObject getJSONMessage(@NotNull User user)
    {
        JSONObject Message = new JSONObject();
        Message message = GetObject.getMessageByUserid(user.getId());
        if(message!=null)
        {
            Message.put("id",message.getId());
            Message.put("Subject",message.getSubject());
            Message.put("Message",message.getMessage());
            Message.put("userid",getJSONUser(message.getUser()));
            Message.put("Organisation",getJSONORG(message.getOrganisation()));
            Message.put("ArriveTime",message.getArriveTime());
            Message.put("DeadLine",message.getDeadline());
            Message.put("Read",message.isRead());
            Message.put("Docs",message.getDocuments());
        }
        return Message;
    }
    public static @NotNull JSONObject getJSONORG(@NotNull Organisation organisation)
    {
        JSONObject org = new JSONObject();
        org.put("Name",organisation.getName());
        org.put("id",organisation.getId());
        org.put("Location",getJSONRLocation(organisation.getLocation()));
        org.put("Nationality",organisation.getNationality());
        return org;
    }
    public static @NotNull JSONObject getJSONRLocation(@NotNull Location location)
    {
        JSONObject orglocation = new JSONObject();
        orglocation.put("id",location.getId());
        orglocation.put("Country",location.getCountry());
        orglocation.put("County",location.getCounty());
        orglocation.put("City",location.getCity());
        orglocation.put("Street",location.getStreet());
        orglocation.put("House Number",location.getHouse_number());
        orglocation.put("Rest",location.getRest());
        orglocation.put("Registration Date",location.getRegistration_date());
        return orglocation;
    }
    public static @NotNull JSONObject getJSONDLocation(@NotNull Location location)
    {
        JSONObject orglocation = new JSONObject();
        orglocation.put("id",location.getId());
        orglocation.put("Country",location.getCountry());
        orglocation.put("County",location.getCounty());
        orglocation.put("City",location.getCity());
        orglocation.put("Street",location.getStreet());
        orglocation.put("House Number",location.getHouse_number());
        orglocation.put("Rest",location.getRest());
        orglocation.put("Registration Date",location.getRegistration_date());
        orglocation.put("Expiry Date",location.getRegistration_date());
        return orglocation;
    }
    public static @NotNull JSONArray getJSONDataUserName(String Username, String MD5Password)
    {
        User user = GetObject.getUserUserName(Username,MD5Password);
        JSONArray userO = new JSONArray();
        userO.put(Objects.requireNonNull(user).getId());
        userO.put(Objects.requireNonNull(user).getName());
        userO.put(user.getUsername());
        userO.put(user.getEmail());
        userO.put(user.getGirlName());
        userO.put(user.getSex());
        userO.put(user.getBirthdate());
        userO.put(user.getNationality());
        userO.put(getJSONIDCard(user));
        userO.put(getJSONLocationCard(user));
        userO.put(getJSONDriversLicense(user));
        return userO;

    }
    public static @NotNull JSONArray getJSONDataEmail(String Email, String MD5Password)
    {
        User user = GetObject.getUserEmail(Email,MD5Password);
        JSONArray userO = new JSONArray();

        userO.put(Objects.requireNonNull(user).getId());
        userO.put(Objects.requireNonNull(user).getName());
        userO.put(user.getUsername());
        userO.put(user.getEmail());
        userO.put(user.getGirlName());
        userO.put(user.getSex());
        userO.put(user.getBirthdate());
        userO.put(user.getNationality());
        userO.put(getJSONIDCard(user));
        userO.put(getJSONLocationCard(user));
        userO.put(getJSONDriversLicense(user));
        return userO;

    }
    public static @NotNull JSONArray getJSONUsers()
    {
        JSONArray object = new JSONArray();
        for(User user : GetArray.getDataFromUserTable())
        {
            object.put(GetJSON.getJSONUser(user));
        }
        return object;
    }
    public static @NotNull JSONArray getJSONLocations()
    {
        JSONArray object = new JSONArray();
        for(Location location : GetArray.getDataFromLocationsTable())
        {
            object.put(GetJSON.getJSONDLocation(location));
        }
        return object;
    }
    public static @NotNull JSONArray getJSONOrganisation()
    {
        JSONArray object = new JSONArray();
        for(Organisation org : GetArray.getDataFromOrganisationsTable())
        {
            object.put(GetJSON.getJSONORG(org));
        }
        return object;
    }
    public static @NotNull JSONArray getJSONIDCards()
    {
        JSONArray object = new JSONArray();
        for(User user : GetArray.getDataFromUserTable())
        {
            object.put(GetJSON.getJSONIDCard(user));
        }
        return object;
    }
    public static @NotNull JSONArray getJSONLocationCards()
    {
        JSONArray object = new JSONArray();
        for(User user : GetArray.getDataFromUserTable())
        {
            object.put(GetJSON.getJSONLocationCard(user));
        }
        return object;
    }
    public static @NotNull JSONArray getJSONDriversLicenses()
    {
        JSONArray object = new JSONArray();
        for(User user : GetArray.getDataFromUserTable())
        {
            object.put(GetJSON.getJSONDriversLicense(user));
        }
        return object;
    }

    @Contract(pure = true)
    public static @Nullable JSONArray getJSONMessages() {
        JSONArray object = new JSONArray();
        for(User user : GetArray.getDataFromUserTable())
        {
            object.put(GetJSON.getJSONMessage(user));
        }
        return object;
    }

}

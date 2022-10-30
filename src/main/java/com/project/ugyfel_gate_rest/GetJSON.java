package com.project.ugyfel_gate_rest;

import com.project.ugyfel_gate_rest.Classes.*;
import com.project.ugyfel_gate_rest.DataBase.GetObject;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.util.Objects;

public class GetJSON
{
    public static @NotNull JSONObject getJSONIDCARD(@NotNull User user)
    {
        ID_CARD id_card = GetObject.getID_CARDByUserid(user.getId());
        JSONObject id_cardO = new JSONObject();

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
        location_cardO.put("Location Card ID", location_card.getLoc_Id());
        location_cardO.put("Default Location",getJSONDLocation(Objects.requireNonNull(location_card).getDefaultlocation()));
        if(location_card.getResidentallocation() != null)
        {
            location_cardO.put("Residental Location",getJSONRLocation(location_card.getResidentallocation()));
        }
        location_cardO.put("Organisation",getJSONORG(location_card.getOrganisation()));
        return location_cardO;
    }
    public static @NotNull JSONObject getJSONDriversLicense(@NotNull User user)
    {
        Drivers_License driversLicense = GetObject.getDriversLicenseByUserid(user.getId());
        JSONObject driversLicenseO = new JSONObject();

        driversLicenseO.put("Card Number",driversLicense.getCard_number());
        driversLicenseO.put("Acquire Date",driversLicense.getAcquire());
        driversLicenseO.put("Expiry Date",driversLicense.getExpiry());
        driversLicenseO.put("Organisation",getJSONORG(driversLicense.getOrgan()));

        return driversLicenseO;
    }
    public static @NotNull JSONObject getJSONORG(@NotNull Organisation organisation)
    {
        JSONObject org = new JSONObject();
        org.put("Name",organisation.getName());

        org.put("Location",getJSONRLocation(organisation.getLocation()));
        org.put("Nationality",organisation.getNationality());
        return org;
    }
    public static @NotNull JSONObject getJSONRLocation(@NotNull Location location)
    {
        JSONObject orglocation = new JSONObject();

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
    public static @NotNull JSONObject getJSONData(String Username, String MD5Password)
    {
        User user = GetObject.getUser(Username,MD5Password);
        JSONObject userO = new JSONObject();

        userO.put("Name", Objects.requireNonNull(user).getName());
        userO.put("User Name",user.getUsername());
        userO.put("Email",user.getEmail());
        userO.put("Girl Name",user.getGirlName());
        userO.put("Sex",user.getSex());
        userO.put("BirthDate",user.getBirthdate());
        userO.put("Nationality",user.getNationality());
        if(getJSONIDCARD(user)!= null) userO.put("ID Card",getJSONIDCARD(user));
        if(getJSONLocationCard(user)!= null) userO.put("Location Card",getJSONLocationCard(user));
        if(getJSONDriversLicense(user) != null) userO.put("Drivers License",getJSONDriversLicense(user));
        return userO;

    }
}

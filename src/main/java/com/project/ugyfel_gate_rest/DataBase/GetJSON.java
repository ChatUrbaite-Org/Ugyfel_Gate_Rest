package com.project.ugyfel_gate_rest.DataBase;

import com.project.ugyfel_gate_rest.Classes.*;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.util.Objects;

public class GetJSON
{
    public static @NotNull JSONObject getJSONUser(@NotNull User user)
    {
        JSONObject id_cardO = new JSONObject();

        id_cardO.put("Name", user.getName());
        id_cardO.put("Girl Name",user.getGirlName());
        id_cardO.put("Email",user.getEmail());
        id_cardO.put("User Name",user.getUsername());
        id_cardO.put("Token",user.getPassword());
        id_cardO.put("Birth Date",user.getBirthdate());
        id_cardO.put("Sex",user.getSex());
        id_cardO.put("Is Mom",user.isMom());
        id_cardO.put("Nationality",user.getNationality());
        id_cardO.put("Active",user.isActive());
        return id_cardO;
    }
    public static @NotNull JSONObject getJSONIDCard(@NotNull User user)
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
        location_cardO.put("Location Card ID", Objects.requireNonNull(location_card).getLoc_Id());
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

        driversLicenseO.put("Card Number", Objects.requireNonNull(driversLicense).getCard_number());
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
    public static @NotNull JSONObject getJSONDataUserName(String Username, String MD5Password)
    {
        User user = GetObject.getUserUserName(Username,MD5Password);
        JSONObject userO = new JSONObject();
        userO.put("ID", Objects.requireNonNull(user).getId());
        userO.put("Name", Objects.requireNonNull(user).getName());
        userO.put("User Name",user.getUsername());
        userO.put("Email",user.getEmail());
        userO.put("Girl Name",user.getGirlName());
        userO.put("Sex",user.getSex());
        userO.put("BirthDate",user.getBirthdate());
        userO.put("Nationality",user.getNationality());
        userO.put("ID Card", getJSONIDCard(user));
        userO.put("Location Card",getJSONLocationCard(user));
        userO.put("Drivers License",getJSONDriversLicense(user));
        return userO;

    }
    public static @NotNull JSONObject getJSONDataEmail(String Email, String MD5Password)
    {
        User user = GetObject.getUserEmail(Email,MD5Password);
        JSONObject userO = new JSONObject();

        userO.put("Name", Objects.requireNonNull(user).getName());
        userO.put("User Name",user.getUsername());
        userO.put("Email",user.getEmail());
        userO.put("Girl Name",user.getGirlName());
        userO.put("Sex",user.getSex());
        userO.put("BirthDate",user.getBirthdate());
        userO.put("Nationality",user.getNationality());
        userO.put("ID Card", getJSONIDCard(user));
        userO.put("Location Card",getJSONLocationCard(user));
        userO.put("Drivers License",getJSONDriversLicense(user));
        return userO;

    }
    public static @NotNull JSONObject getJSONUsers()
    {
        JSONObject object = new JSONObject();
        for(User user : GetArray.getDataFromUserTable())
        {
            object.put("User"+user.getId(),GetJSON.getJSONUser(user));
        }
        return object;
    }
    public static @NotNull JSONObject getJSONLocations()
    {
        JSONObject object = new JSONObject();
        for(Location location : GetArray.getDataFromLocationsTable())
        {
            object.put("Location"+location.getId(),GetJSON.getJSONDLocation(location));
        }
        return object;
    }
    public static @NotNull JSONObject getJSONOrganisation()
    {
        JSONObject object = new JSONObject();
        for(Organisation org : GetArray.getDataFromOrganisationsTable())
        {
            object.put("Organisation"+org.getId(),GetJSON.getJSONORG(org));
        }
        return object;
    }
    public static @NotNull JSONObject getJSONIDCards()
    {
        JSONObject object = new JSONObject();
        for(User user : GetArray.getDataFromUserTable())
        {
            object.put("ID Card"+ Objects.requireNonNull(GetObject.getID_CARDByUserid(user.getId())).getId(),GetJSON.getJSONIDCard(user));
        }
        return object;
    }
    public static @NotNull JSONObject getJSONLocationCards()
    {
        JSONObject object = new JSONObject();
        for(User user : GetArray.getDataFromUserTable())
        {
            object.put("Location Card"+ Objects.requireNonNull(GetObject.getLocation_CARDByUserid(user.getId())).getId(),GetJSON.getJSONLocationCard(user));
        }
        return object;
    }
    public static @NotNull JSONObject getJSONDriversLicenses()
    {
        JSONObject object = new JSONObject();
        for(User user : GetArray.getDataFromUserTable())
        {
            object.put("Drivers License"+ Objects.requireNonNull(GetObject.getDriversLicenseByUserid(user.getId())).getId(),GetJSON.getJSONDriversLicense(user));
        }
        return object;
    }

}

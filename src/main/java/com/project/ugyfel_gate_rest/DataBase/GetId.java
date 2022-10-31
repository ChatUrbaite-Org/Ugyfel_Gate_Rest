package com.project.ugyfel_gate_rest.DataBase;

import com.project.ugyfel_gate_rest.Classes.Location;
import com.project.ugyfel_gate_rest.Classes.Organisation;
import com.project.ugyfel_gate_rest.Classes.User;

import java.util.ArrayList;
import java.util.Objects;

import static com.project.ugyfel_gate_rest.DataBase.GetArray.*;

public class GetId
{
    public static int getlocationID(Location location0)
    {
        ArrayList<Location> locations= getDataFromLocationsTable();
        for (Location location : locations)
        {
            /*System.out.println(location.getCountry()+location0.getCountry()+" "
                    +location.getCounty()+location0.getCounty()+" "
                    +location.getCity()+location0.getCity()+" "
                    +location.getHouse_number()+location0.getHouse_number()+" "
                    +location.getRest()+location0.getRest()+" "
                    +location.getRegistration_date() + location0.getRegistration_date()+" "
            );*/
            if(Objects.equals(location.getCountry(), location0.getCountry())
                    && Objects.equals(location.getCounty(), location0.getCounty())
                    && Objects.equals(location.getCity(), location0.getCity())
                    &&location.getHouse_number() == location0.getHouse_number()
                    && Objects.equals(location.getRest(), location0.getRest())
                    && Objects.equals(location.getRegistration_date().toString(), location0.getRegistration_date().toString())
            )
            {
                return location.getId();
            }
        }
        return 0;
    }

    public static int getOrgId(Organisation organ)
    {
        ArrayList<Organisation> organisations= getDataFromOrganisationsTable();
        for (Organisation organisation : organisations)
        {
            if(Objects.equals(organisation.getName(), organ.getName()))
            {
                return organisation.getId();
            }
        }
        return 0;
    }

    public static int getUserId(User user) {
        ArrayList<User> users = getDataFromUserTable();
        for (User user0 : users)
        {
            //System.out.println(user0.getUsername()+" "+user.getUsername());
            //System.out.println(user0.getPassword()+" "+user.getPassword().toString());
            if(Objects.equals(user0.getUsername(), user.getUsername()) && Objects.equals(user0.getPassword(), user.getPassword()))
            {
                return user0.getId();
            }
        }
        return 0;
    }
}

package com.project.ugyfel_gate_rest.Classes;


import com.project.ugyfel_gate_rest.Enums.Nationality;

public class Organisation
{
    private int id;
    private String Name;
    private Location Location;
    private Nationality nationality;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Location getLocation() {
        return Location;
    }

    public void setLocation(Location location) {
        Location = location;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality country) {
        nationality = country;
    }

    public Organisation(String name, Location location, Nationality nationality)
    {
        this.Name = name;
        this.Location = location;
        this.nationality = nationality;
    }

    public Organisation(int id, String name, Location location, Nationality nationality) {
        this.id = id;
        Name = name;
        Location = location;
        this.nationality = nationality;
    }
}

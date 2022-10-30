package com.project.ugyfel_gate_rest.Classes;


public class Location_CARD
{
    private int id;
    private final String Loc_Id;
    private final Location defaultlocation;
    private Location Residentallocation;
    private User user;
    private final Organisation organisation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoc_Id() {
        return Loc_Id;
    }

    public Location getDefaultlocation() {
        return defaultlocation;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public Location getResidentallocation() {
        return Residentallocation;
    }

    public Location_CARD(String loc_Id, Location defaultlocation, Location residentallocation, User user, Organisation organisation) {
        Loc_Id = loc_Id;
        this.defaultlocation = defaultlocation;
        this.user = user;
        this.organisation = organisation;
        Residentallocation = residentallocation;
    }

    public Location_CARD(String loc_Id, Location defaultlocation, User user, Organisation organisation) {
        Loc_Id = loc_Id;
        this.defaultlocation = defaultlocation;
        this.user = user;
        this.organisation = organisation;
    }

    public Location_CARD(int id, String loc_Id, Location defaultlocation, Location residentallocation, User user, Organisation organisation) {
        this.id = id;
        Loc_Id = loc_Id;
        this.defaultlocation = defaultlocation;
        this.user = user;
        this.organisation = organisation;
        Residentallocation = residentallocation;
    }

    public Location_CARD(int id, String loc_Id, Location defaultlocation, User user, Organisation organisation) {
        this.id = id;
        Loc_Id = loc_Id;
        this.defaultlocation = defaultlocation;
        this.user = user;
        this.organisation = organisation;
    }
}

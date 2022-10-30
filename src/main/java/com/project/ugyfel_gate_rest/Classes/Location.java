package com.project.ugyfel_gate_rest.Classes;

import java.util.Date;

public class Location
{
    private int id;
    private final String country;
    private final String county;
    private final String city;
    private final String street;
    private final int house_number;
    private final String rest;
    private final Date registration_date;
    private Date expiration_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public int getHouse_number() {
        return house_number;
    }

    public String getCountry() {
        return country;
    }

    public String getCounty() {
        return county;
    }

    public String getStreet() {
        return street;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public String getRest() {
        return rest;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public Location(String country, String county, String city, String street, int house_number, String rest, Date registration_date, Date expiration_date) {
        this.country = country;
        this.county = county;
        this.city = city;
        this.street = street;
        this.house_number = house_number;
        this.registration_date = registration_date;
        this.expiration_date = expiration_date;
        this.rest = rest;
    }

    public Location(String country, String county, String city, String street, int house_number, String rest, Date registration_date) {
        this.country = country;
        this.county = county;
        this.city = city;
        this.street = street;
        this.house_number = house_number;
        this.registration_date = registration_date;
        this.rest = rest;
    }

    public Location(int id, String country, String county, String city, String street, int house_number, String rest, Date registration_date, Date expiration_date) {
        this.id = id;
        this.country = country;
        this.county = county;
        this.city = city;
        this.street = street;
        this.house_number = house_number;
        this.registration_date = registration_date;
        this.expiration_date = expiration_date;
        this.rest = rest;
    }
}

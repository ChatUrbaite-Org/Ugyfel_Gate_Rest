package com.project.ugyfel_gate_rest.Classes;


import java.util.Date;

public class Drivers_License
{
    private int id;
    private User user;
    private final String card_number;
    private final Date expiry;
    private final Date acquire;
    private final Organisation organ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getAcquire() {
        return acquire;
    }

    public Date getExpiry() {
        return expiry;
    }

    public String getCard_number() {
        return card_number;
    }

    public Organisation getOrgan() {
        return organ;
    }

    public User getUser() {
        return user;
    }



    public Drivers_License(User user, String card_number, Date expiry, Date acquire, Organisation organ) {
        this.user = user;
        this.card_number = card_number;
        this.expiry = expiry;
        this.acquire = acquire;
        this.organ = organ;
    }

    public Drivers_License(int id, User user, String card_number, Date expiry, Date acquire, Organisation organ) {
        this.id = id;
        this.user = user;
        this.card_number = card_number;
        this.expiry = expiry;
        this.acquire = acquire;
        this.organ = organ;
    }
}

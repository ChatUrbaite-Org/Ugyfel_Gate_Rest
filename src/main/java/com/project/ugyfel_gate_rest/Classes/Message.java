package com.project.ugyfel_gate_rest.Classes;


import java.util.Date;

public class Message
{
    private int id;
    private final String Subject;
    private User user;
    private final Organisation organisation;
    private final String message;
    private final Date arriveTime;
    private final Date deadline;
    private final Boolean isRead;
    private final Boolean documents;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return Subject;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public String getMessage() {
        return message;
    }

    public Date getDeadline() {
        return deadline;
    }

    public Boolean isRead() {
        return isRead;
    }

    public Boolean getDocuments() {
        return documents;
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

    public Message(int id, User user, Organisation organisation, String subject, String message, Date arriveTime, Date deadline, Boolean isRead, Boolean documents) {
        this.id = id;
        Subject = subject;
        this.user = user;
        this.organisation = organisation;
        this.message = message;
        this.arriveTime = arriveTime;
        this.deadline = deadline;
        this.isRead = isRead;
        this.documents = documents;
    }

    public Message(User user, Organisation organisation,String subject,  String message, Date arriveTime, Date deadline, Boolean isRead, Boolean documents) {
        Subject = subject;
        this.user = user;
        this.organisation = organisation;
        this.message = message;
        this.arriveTime = arriveTime;
        this.deadline = deadline;
        this.isRead = isRead;
        this.documents = documents;
    }
}

package com.example.oblig3_data1700;

public class Tickets {
    private String movie;
    private String numberOfTickets;
    private String fname;
    private String lname;
    private String email;
    private String phone;

    public Tickets(String movie, String numberOfTickets, String fname, String lname, String email, String phone) {
        this.movie = movie;
        this.numberOfTickets = numberOfTickets;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(String numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

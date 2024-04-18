package com.example.oblig3data1700_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class TicketRepository {
    @Autowired
    private JdbcTemplate db;

    public void saveTickets(tickets inTickets){
        String sql = "INSERT INTO tickets (movie, numberOfTickets, fname, lname, email, phone) VALUES(?,?,?,?,?,?)";
        db.update(sql,inTickets.getMovie(),
                inTickets.getNumberOfTickets(),
                inTickets.getFname(),
                inTickets.getLname(),
                inTickets.getEmail(),
                inTickets.getPhone());
    }
}

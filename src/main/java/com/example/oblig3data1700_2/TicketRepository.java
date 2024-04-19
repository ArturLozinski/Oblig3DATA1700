package com.example.oblig3data1700_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketRepository {

    @Autowired
    private JdbcTemplate db;

    public void saveTickets(Tickets inTickets) {
        String sql = "INSERT INTO tickets (movie, numberOfTickets, fname, lname, email, phone) VALUES(?,?,?,?,?,?)";
        db.update(sql,
                inTickets.getMovie(),
                inTickets.getNumberOfTickets(),
                inTickets.getFname(),
                inTickets.getLname(),
                inTickets.getEmail(),
                inTickets.getPhone());
    }

    public List<Tickets> getAllTickets() {
        String sql = "SELECT * FROM Tickets ORDER BY lname";
        List<Tickets> alleBilletter = db.query(sql, new BeanPropertyRowMapper(Tickets.class));
        return alleBilletter;
    }

    public void deleteAllTickets() {
        String sql = "DELETE FROM Tickets";
        db.update(sql);
    }
}

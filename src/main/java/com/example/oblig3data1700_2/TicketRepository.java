package com.example.oblig3_data1700;

package com.example.obligatorisk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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

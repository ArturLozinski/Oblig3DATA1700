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

        System.out.println("tickets " + inTickets);

        String sql = "INSERT INTO Tickets (movie, numberOfTickets, fname, lname, email, phone) VALUES(?,?,?,?,?,?)";
        db.update(sql,
                inTickets.getMovie(),
                inTickets.getNumberOfTickets(),
                inTickets.getFname(),
                inTickets.getLname(),
                inTickets.getEmail(),
                inTickets.getPhone());
    }

    public List<Tickets> getAllTickets() {
        String sql = "SELECT * FROM Tickets";
        List<Tickets> allTickets = db.query(sql, new BeanPropertyRowMapper<>(Tickets.class));
        System.out.println(allTickets);
        return allTickets;
    }

    public Tickets getOneTicket(Integer id) {
        String sql = "SELECT * FROM Tickets WHERE id=?";
        Object[] param = new Object[]{id};
        List<Tickets> result = db.query(sql, param, BeanPropertyRowMapper.newInstance(Tickets.class));
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
    }
    public void editTicket(Tickets inTickets){
        String sql = "UPDATE Tickets SET movie=?, numberOfTickets=?, fname=?, lname=?, email=?, phone=? WHERE id=?";
        db.update(sql,
                inTickets.getMovie(),
                inTickets.getNumberOfTickets(),
                inTickets.getFname(),
                inTickets.getLname(),
                inTickets.getEmail(),
                inTickets.getPhone());
    }
    public void deleteOne(Integer id) {
        String sql = "DELETE FROM Tickets WHERE id=?";
        db.update(sql);
    }

    public void deleteAllTickets() {
        String sql = "DELETE FROM Tickets";
        db.update(sql);
    }
}

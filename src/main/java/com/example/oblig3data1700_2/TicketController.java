package com.example.oblig3_data1700;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class TicketController {
    @Autowired
    ticketRepository rep;

    @PostMapping("/save")
    public void save(tickets ticket) {
        rep.saveTickets(ticket);
    }

    @GetMapping("/getAll")
    public List<tickets> getAll() {
        return rep.getAllTickets();
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        rep.deleteAllTickets();
    }

}

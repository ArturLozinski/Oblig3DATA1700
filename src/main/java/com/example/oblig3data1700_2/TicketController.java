package com.example.oblig3data1700_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

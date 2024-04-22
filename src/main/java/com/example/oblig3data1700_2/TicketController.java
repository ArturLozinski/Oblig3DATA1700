package com.example.oblig3data1700_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class TicketController {
    @Autowired
    TicketRepository rep;

    @PostMapping("/save")
    public void saveTickets(Tickets ticket) {
        rep.saveTickets(ticket);
    }

    @GetMapping("/getAll")
    public List<Tickets> getAllTickets() {
        return rep.getAllTickets();
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllTickets() {
        rep.deleteAllTickets();
    }

}

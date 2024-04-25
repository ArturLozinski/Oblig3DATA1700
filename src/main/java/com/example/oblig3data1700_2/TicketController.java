package com.example.oblig3data1700_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class TicketController {
    @Autowired
    TicketRepository rep;

    @PostMapping("/save")
    public void saveTickets(@RequestBody Tickets ticket) {
        System.out.println(ticket);
        rep.saveTickets(ticket);
    }


    @GetMapping("/getAll")
    public List<Tickets> getAllTickets() {

        return rep.getAllTickets();
    }

    @GetMapping("/getOneTicket")
    public Tickets getOneTicket(Integer id) {
        return rep.getOneTicket(id);
    }

    @PostMapping("/editTicket")
    public void editTicket(@RequestBody Tickets ticket) {
        System.out.println("INPUT: " );
        System.out.println(ticket.getId());
        rep.editTicket(ticket);
    }

    @GetMapping("/deleteOne")
    public void deleteOne(Integer id) {
        rep.deleteOne(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllTickets() {
        rep.deleteAllTickets();
    }

}

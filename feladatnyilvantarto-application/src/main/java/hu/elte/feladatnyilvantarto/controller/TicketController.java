package hu.elte.feladatnyilvantarto.controller;

import hu.elte.feladatnyilvantarto.domain.Group;
import hu.elte.feladatnyilvantarto.domain.Ticket;
import hu.elte.feladatnyilvantarto.service.GroupsService;
import hu.elte.feladatnyilvantarto.service.TicketListService;
import hu.elte.feladatnyilvantarto.service.TicketService;
import hu.elte.feladatnyilvantarto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TicketController extends AuthenticatedControllerBase{

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketListService ticketListService;
    @Autowired
    private GroupsService groupsService;

    @Autowired
    private UserService userService;

    @GetMapping("/ticket/{id}")
    public String GetTicket(@PathVariable("id") int id, Model model)
    {
        Ticket ticket = ticketService.ticketById(id);
        model.addAttribute("ticket", ticket);
        model.addAttribute("id",id);

        return "ticket";
    }

    @PostMapping("/ticket/startaction/{id}")
    public String StartTicket (@PathVariable("id") int id) {
        Ticket ticket = ticketService.ticketById(id);
        ticket.setCheckbox(true);
        return "/ticket/" + id;
    }

    @GetMapping("/ticket/pauseaction/{id}")
    public String PauseTicket (@PathVariable("id") int id) {
        Ticket ticket = ticketService.ticketById(id);
        ticket.setCheckbox(false);
        return "/ticket/" + id;
    }

    @GetMapping("/ticket/finishaction/{id}")
    public String FinishTicket (@PathVariable("id") int id) {
        Ticket ticket = ticketService.ticketById(id);
        ticket.setCheckbox(false);
        return "/ticket/" + id;
    }

}

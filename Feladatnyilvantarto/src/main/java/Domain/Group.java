package Domain;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class Group {
    private ArrayList<Ticket> tickets;
    private User leader;
    private ArrayList<User> workers;
    public Group(User leader)
    {
        if(leader.getUserType() != UserType.Leader)
        {
            throw new InvalidParameterException("Worker cannot be leader in a group!");
        }
        this.leader = leader;
        workers = new ArrayList<User>();
        tickets = new ArrayList<Ticket>();
    }

    public User getLeader()
    {
        return leader;
    }

    public ArrayList<User> getWorkers()
    {
        return workers;
    }
    public ArrayList<Ticket> getTickets()
    {
        return tickets;
    }

    public void addTicket(Ticket ticket)
    {
        if(!tickets.contains(ticket))
        {
            tickets.add(ticket);
        }
    }

    public void removeTicket(Ticket ticket)
    {
        if(tickets.contains(ticket))
        {
            tickets.remove(ticket);
        }
    }

    public void addWorker(User user)
    {
        if(user.getUserType() == UserType.Worker && !workers.contains(user))
        {
            workers.add(user);
        }
    }

    public void removeWorker(User user)
    {
        if(user.getUserType() == UserType.Worker && workers.contains(user))
        {
            workers.remove(user);
        }
    }
}

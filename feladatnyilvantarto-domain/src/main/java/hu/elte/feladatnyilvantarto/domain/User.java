package hu.elte.feladatnyilvantarto.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "USERS")
public class User
{
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @Embedded
    private Credentials credentials;
    @OneToMany
    private List<Group> groups;
    @OneToMany(mappedBy = "leader", cascade = {CascadeType.MERGE})
    private List<Group> groupsLed;
    @OneToMany(mappedBy = "user", cascade = {CascadeType.MERGE})
    private List<TimeMeasure> userTimeMeasures;

    @OneToOne
    private Ticket currentTicket;

    @ManyToMany(mappedBy = "assignees")
    private List<Ticket> assignedTickets;
    public Ticket getCurrentTicket() {
        return currentTicket;
    }

    public void setCurrentTicket(Ticket currentTicket) {
        this.currentTicket = currentTicket;
    }

    public User(String name, Credentials credentials)
    {
        this.name = name;
        this.credentials = credentials;
        this.groups = new ArrayList<>();
        this.assignedTickets = new ArrayList<>();
    }

    public User() {
        this.groups = new ArrayList<>();
        this.assignedTickets = new ArrayList<>();
    }

    public List<Group> getGroupsLed() {
        return groupsLed;
    }

    public void setGroupsLed(List<Group> groupsLed) {
        this.groupsLed = groupsLed;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getName()
    {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getId()
    {
        return id;
    }



    public Credentials getCredentials()
    {
        return credentials;
    }
    public void setCredentials(Credentials cred)
    {
        this.credentials = cred;
    }
    public List<Group> getGroups()
    {
        return groups;
    }

    public List<Ticket> getAssignedTickets()
    {
/*        List<Ticket> result = new ArrayList<Ticket>();
        for(Group group:groups)
        {
            result.addAll(group.getTickets().stream().filter((t) -> (userType == UserType.Worker)?t.getAssignees().contains(this):t.getAssigner().equals(this)).collect(Collectors.toList()));
        }
        Ez majd a service logikába kerül bele
 */

        return assignedTickets;
    }

    public List<TimeMeasure> getUserTimeMeasures() {
        return userTimeMeasures;
    }

    public void setUserTimeMeasures(List<TimeMeasure> userTimeMeasures) {
        this.userTimeMeasures = userTimeMeasures;
    }

}
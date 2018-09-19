package pl.coderslab.receiver.model;

import pl.coderslab.receiver.service.UserService;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;


@Entity
@Table (name = "betwins")
public class BetWin
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private User user;

    @OneToMany
    private Map<Integer,Event> bets = new HashMap<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<Integer, Event> getBets() {
        return bets;
    }

    public void setBets(Map<Integer, Event> bets) {
        this.bets = bets;
    }
}

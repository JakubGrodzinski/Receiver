package pl.coderslab.receiver.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "events")
public class Event
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Team team1;
    @ManyToOne
    private Team team2;


    private int team1score;

    private int team2score;

    private Date beginning;

    private Date end;

    public Event(Team team1, Team team2, int team1score, int team2score, Date beginning, Date end) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1score = team1score;
        this.team2score = team2score;
        this.beginning = beginning;
        this.end = end;
    }

    public Event () {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public int getTeam1score() {
        return team1score;
    }

    public void setTeam1score(int team1score) {
        this.team1score = team1score;
    }

    public int getTeam2score() {
        return team2score;
    }

    public void setTeam2score(int team2score) {
        this.team2score = team2score;
    }

    public Date getBeginning() {
        return beginning;
    }

    public void setBeginning(Date beginning) {
        this.beginning = beginning;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}

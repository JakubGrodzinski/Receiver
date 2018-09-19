package pl.coderslab.receiver.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.coderslab.receiver.model.Team;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventDto
{
    @JsonProperty("id")
    private Long id;

    @JsonProperty("team1")
    private Team team1;

    @JsonProperty("team2")
    private Team team2;

    @JsonProperty("team1score")
    private int team1score;

    @JsonProperty("team2score")
    private int team2score;

    @JsonProperty("beginning")
    private Date beginning;

    @JsonProperty("end")
    private Date end;

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

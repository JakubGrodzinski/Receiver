package pl.coderslab.receiver.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.coderslab.receiver.model.League;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamDto
{
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("league")
    private League league;

    @JsonProperty("attackPotential")
    private int attackPotential;

    @JsonProperty("defencePotential")
    private int defencePotential;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public int getAttackPotential() {
        return attackPotential;
    }

    public void setAttackPotential(int attackPotential) {
        this.attackPotential = attackPotential;
    }

    public int getDefencePotential() {
        return defencePotential;
    }

    public void setDefencePotential(int defencePotential) {
        this.defencePotential = defencePotential;
    }
}

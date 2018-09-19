package pl.coderslab.receiver.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.receiver.DTO.TeamDto;
import pl.coderslab.receiver.model.Team;
@Component
public class TeamConverter implements Converter<TeamDto, Team>
{
    @Override
    public Team convert(TeamDto teamDto)
    {
        Team team = new Team();
        team.setName(teamDto.getName());
        team.setLeague(teamDto.getLeague());
        team.setAttackPotential(teamDto.getAttackPotential());
        team.setDefencePotential(teamDto.getDefencePotential());
        return team;
    }
}

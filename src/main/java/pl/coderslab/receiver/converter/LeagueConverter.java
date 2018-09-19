package pl.coderslab.receiver.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.receiver.DTO.LeagueDto;
import pl.coderslab.receiver.model.League;
@Component
public class LeagueConverter implements Converter<LeagueDto, League>
{
    @Override
    public League convert(LeagueDto leagueDto)
    {
        League league = new League();
        league.setName(leagueDto.getName());
        league.setCountry(leagueDto.getCountry());
        league.setTeams(leagueDto.getTeams());
        return league;
    }
}

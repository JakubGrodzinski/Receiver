package pl.coderslab.receiver.service;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.coderslab.receiver.DTO.CountryDto;
import pl.coderslab.receiver.DTO.EventDto;
import pl.coderslab.receiver.DTO.LeagueDto;
import pl.coderslab.receiver.DTO.TeamDto;

@Service
public class ReceiveDataService
{
    public CountryDto[] receivedCountries ()
    {
        String url = "http://localhost:8090/countries";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CountryDto[]> responseCountries = restTemplate.getForEntity(url, CountryDto[].class);
        CountryDto[] countries = responseCountries.getBody();
        return countries;
    }

    public LeagueDto[] receivedLeagues ()
    {
        String url = "http://localhost:8090/leagues";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<LeagueDto[]> responseLeagues = restTemplate.getForEntity(url, LeagueDto[].class);
        LeagueDto[] leagues = responseLeagues.getBody();
        return leagues;
    }

    public TeamDto[] receivedTeams ()
    {
        String url = "http://localhost:8090/teams";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TeamDto[]> responseLeagues = restTemplate.getForEntity(url, TeamDto[].class);
        TeamDto[] teams = responseLeagues.getBody();
        return teams;
    }

    public EventDto[] receiveEvents ()
    {
        String url = "http://localhost:8090/events";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<EventDto[]> responseLeagues = restTemplate.getForEntity(url, EventDto[].class);
        EventDto[] events = responseLeagues.getBody();
        return events;
    }
    @Scheduled(fixedRate = 4000)
    public EventDto[] receiveOngoingEvents ()
    {
        String url = "http://localhost:8090/ongoing";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<EventDto[]> responseLeagues = restTemplate.getForEntity(url, EventDto[].class);
        EventDto[] events = responseLeagues.getBody();
        return events;
    }
    @Scheduled(fixedRate = 4000)
    public EventDto[] receiveFinishedEvents ()
    {
        String url = "http://localhost:8090/finished";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<EventDto[]> responseLeagues = restTemplate.getForEntity(url, EventDto[].class);
        EventDto[] events = responseLeagues.getBody();
        return events;
    }


}

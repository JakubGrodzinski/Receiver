package pl.coderslab.receiver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.coderslab.receiver.DTO.CountryDto;
import pl.coderslab.receiver.DTO.EventDto;
import pl.coderslab.receiver.DTO.LeagueDto;
import pl.coderslab.receiver.DTO.TeamDto;
import pl.coderslab.receiver.converter.CountryConverter;
import pl.coderslab.receiver.converter.EventConverter;
import pl.coderslab.receiver.converter.LeagueConverter;
import pl.coderslab.receiver.converter.TeamConverter;
import pl.coderslab.receiver.model.Country;
import pl.coderslab.receiver.model.Event;
import pl.coderslab.receiver.model.League;
import pl.coderslab.receiver.model.Team;
import pl.coderslab.receiver.repository.CountryRepository;
import pl.coderslab.receiver.repository.EventRepository;
import pl.coderslab.receiver.repository.LeagueRepository;
import pl.coderslab.receiver.repository.TeamRepository;

import java.util.HashSet;

@Service
public class ImportService {

    @Autowired
    ReceiveDataService receiveDataService;

    @Autowired
    CountryConverter countryConverter;

    @Autowired
    LeagueConverter leagueConverter;

    @Autowired
    TeamConverter teamConverter;

    @Autowired
    EventConverter eventConverter;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    LeagueRepository leagueRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    EventRepository eventRepository;

    @Scheduled(fixedRate = 5000)
    public void importCountries(){
        System.out.println("Import countries");
        CountryDto[] countries = receiveDataService.receivedCountries();
        for (CountryDto countryDto: countries)
        {
            Country country = countryConverter.convert(countryDto);
            if (countryRepository.findByName(country.getName()) == null){
                country.setId( null );
                country.setLeagues(new HashSet<>());

                countryRepository.save(country);
            }
        }
    }

    @Scheduled(fixedRate = 5000)
    public void importLeagues(){
        System.out.println("Import leagues");
        LeagueDto[] leagues = receiveDataService.receivedLeagues();
        for (LeagueDto leagueDto: leagues)
        {
            League league = leagueConverter.convert(leagueDto);
            if (leagueRepository.findByName(league.getName()) == null){
                league.setId( null );
                league.setTeams(new HashSet<>());

                leagueRepository.save(league);
            }
        }
    }

    @Scheduled(fixedRate = 5000)
    public void importTeams(){
        System.out.println("Import teams");
        TeamDto[] teams = receiveDataService.receivedTeams();
        for (TeamDto teamDto : teams)
        {
            Team team = teamConverter.convert(teamDto);
            if (teamRepository.findByName(team.getName()) == null){
                team.setId( null );
                teamRepository.save(team);
            }
        }
    }

    @Scheduled(fixedRate = 5000)
    public void importEvents(){
        System.out.println("Import events");
        EventDto[] events = receiveDataService.receiveEvents();
        for (EventDto eventDto : events)
        {
            Event event = eventConverter.convert(eventDto);
            Event eventInDb  = eventRepository.findByBeginningAndAndTeam1AndTeam2(event.getBeginning(), event.getTeam1(), event.getTeam2());
            if (eventInDb == null){
                event.setId(null);
            }else
                {
                eventInDb.setTeam1score(event.getTeam1score());
                eventInDb.setTeam2score(event.getTeam2score());
            }
            eventRepository.save(event);
        }
    }

    @Scheduled(fixedRate = 5000)
    public void importOngoingEvents(){
        System.out.println("Import ongoing events");
        EventDto[] events = receiveDataService.receiveOngoingEvents();
        for (EventDto eventDto : events)
        {
            Event event = eventConverter.convert(eventDto);
            Event eventInDb  = eventRepository.findByBeginningAndAndTeam1AndTeam2(event.getBeginning(), event.getTeam1(), event.getTeam2());
            if (eventInDb == null){
                event.setId(null);
            }else
            {
                eventInDb.setTeam1score(event.getTeam1score());
                eventInDb.setTeam2score(event.getTeam2score());
            }
            eventRepository.save(event);
        }
    }

    @Scheduled(fixedRate = 5000)
    public void importFinishedEvents(){
        System.out.println("Import finished events");
        EventDto[] events = receiveDataService.receiveFinishedEvents();
        for (EventDto eventDto : events)
        {
            Event event = eventConverter.convert(eventDto);
            Event eventInDb  = eventRepository.findByBeginningAndAndTeam1AndTeam2(event.getBeginning(), event.getTeam1(), event.getTeam2());
            if (eventInDb == null){
                event.setId(null);
            }else
            {
                eventInDb.setTeam1score(event.getTeam1score());
                eventInDb.setTeam2score(event.getTeam2score());
            }
            eventRepository.save(event);
        }
    }


}

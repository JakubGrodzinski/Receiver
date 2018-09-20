package pl.coderslab.receiver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.receiver.model.Event;
import pl.coderslab.receiver.model.Team;

import java.util.Date;

public interface EventRepository extends JpaRepository <Event, Long>
{
    Event findByBeginningAndAndTeam1AndTeam2 (Date beginning, Team team1, Team team2);
}

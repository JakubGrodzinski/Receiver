package pl.coderslab.receiver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.receiver.model.League;

public interface LeagueRepository extends JpaRepository<League, Long>
{
    League findByName (String name);
}

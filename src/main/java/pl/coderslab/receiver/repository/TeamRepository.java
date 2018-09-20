package pl.coderslab.receiver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.receiver.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long>
{
    Team findByName (String name);
}

package pl.coderslab.receiver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.receiver.model.Event;

public interface EventRepository extends JpaRepository <Event, Long>
{
}

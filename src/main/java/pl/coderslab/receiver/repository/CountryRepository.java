package pl.coderslab.receiver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.receiver.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long>
{

}

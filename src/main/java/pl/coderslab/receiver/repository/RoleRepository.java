package pl.coderslab.receiver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.receiver.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>
{
    Role findByName (String name);
}

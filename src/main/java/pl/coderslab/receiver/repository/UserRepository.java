package pl.coderslab.receiver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.receiver.model.User;

@Repository
public interface UserRepository extends JpaRepository <User, Long>
{
    User findByUsername (String userName);
}

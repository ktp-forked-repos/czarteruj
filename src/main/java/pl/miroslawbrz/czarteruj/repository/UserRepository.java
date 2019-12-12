package pl.miroslawbrz.czarteruj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.miroslawbrz.czarteruj.model.User;

public interface UserRepository extends JpaRepository<User, Long> {


    User findByEmail(String email);

}

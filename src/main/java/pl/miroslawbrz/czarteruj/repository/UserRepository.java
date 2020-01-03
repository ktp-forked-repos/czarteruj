package pl.miroslawbrz.czarteruj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.miroslawbrz.czarteruj.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findByEmail(String email);

    User findByHash(int hash);

}

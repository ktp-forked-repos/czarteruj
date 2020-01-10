package pl.miroslawbrz.czarteruj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.miroslawbrz.czarteruj.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findByEmail(String email);
  @Query(value = "UPDATE users SET active = ?1 WHERE users.hash = ?2", nativeQuery = true)
    void updateUserActivation(boolean isActive, int hash);

    @Query(value = "UPDATE users SET hash = ?1 WHERE users.email = ?2", nativeQuery = true)
    void updateUserHash(int hash, String mail);



}

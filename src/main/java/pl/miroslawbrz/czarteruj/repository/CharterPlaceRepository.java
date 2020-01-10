package pl.miroslawbrz.czarteruj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.miroslawbrz.czarteruj.model.CharterPlace;

@Repository
public interface CharterPlaceRepository extends JpaRepository<CharterPlace, Long> {


    @Query(value = "INSERT INTO users_charter_places (user_id, charter_places_id) values (?1, ?2)", nativeQuery = true)
    void addCharterPlaceToUser(Long userId, Long CharterPlaceId);



}

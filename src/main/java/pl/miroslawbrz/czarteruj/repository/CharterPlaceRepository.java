package pl.miroslawbrz.czarteruj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.miroslawbrz.czarteruj.model.CharterPlace;

@Repository
public interface CharterPlaceRepository extends JpaRepository<CharterPlace, Long> {

}

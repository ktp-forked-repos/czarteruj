package pl.miroslawbrz.czarteruj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.miroslawbrz.czarteruj.model.Yacht;

@Repository
public interface YachtRepository extends JpaRepository<Yacht, Integer> {

    @Query(value = "INSERT INTO charter_place_yacht_list (charter_place_id, yacht_list_id) values (?1, ?2)", nativeQuery = true)
    void addYachtToCharterPlace(Long CharterPlaceId, Long yachtId);

}

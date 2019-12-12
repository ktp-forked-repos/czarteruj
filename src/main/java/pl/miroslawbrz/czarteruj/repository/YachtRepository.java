package pl.miroslawbrz.czarteruj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.miroslawbrz.czarteruj.model.Yacht;

@Repository
public interface YachtRepository extends JpaRepository<Yacht, Integer> {

}

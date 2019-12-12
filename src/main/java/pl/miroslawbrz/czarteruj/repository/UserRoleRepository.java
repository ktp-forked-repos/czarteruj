package pl.miroslawbrz.czarteruj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.miroslawbrz.czarteruj.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    UserRole findByRole(String role);

}

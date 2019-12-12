package pl.miroslawbrz.czarteruj.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "userRoles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;
    private String description;

}

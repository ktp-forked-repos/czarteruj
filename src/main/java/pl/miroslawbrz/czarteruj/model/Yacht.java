package pl.miroslawbrz.czarteruj.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Yacht {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String yachtModel;
    private Integer maxCapacity;
    private Double pricePerDay;
    private Double sailSize;
    private Integer enginePowerInHorsePower;
    private String description;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<YachtPerk> yachtPerks;

}

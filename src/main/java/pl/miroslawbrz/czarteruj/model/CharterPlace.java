package pl.miroslawbrz.czarteruj.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class CharterPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String charterPlaceName;
    private String webSiteUrl;
    private double mapLatitude;
    private double mapLongitude;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Address address;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Yacht> yachtList;

}

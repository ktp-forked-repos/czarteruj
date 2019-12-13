package pl.miroslawbrz.czarteruj.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "YachtPerks")
public class YachtPerk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "perkName")
    private String yachtPerkName;
    private byte[] image;

}

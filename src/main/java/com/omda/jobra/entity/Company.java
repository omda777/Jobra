package com.omda.jobra.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name ="companies")
@Getter
@Setter
public class Company extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID" , unique = true, nullable = false)
    private long id;

    @Column(name = "NAME" , nullable = false , length = 100)
    private String name;

    @Column(name = "LOGO" ,  length = 500)
    private String logo;

    @Column(name = "INDUSTRY" , nullable = false , length = 100)
    private String industry;

    @Column(name = "SIZE" , nullable = false , length = 50)
    private String size;

    @Column(name = "RATING" , nullable = false , precision = 3, scale = 2 )
    private BigDecimal rating;

    @Column(name = "LOCATIONS" , length = 1000)
    private String locations;

    @Column(name = "FOUNDED" , nullable = false )
    private int founded;

    @Lob
    @Column(name = "DESCRIPTION")
    private String  description;

    @Column(name = "EMPLOYEES")
    private Integer employees;

    @Column(name = "WEBSITE" , length = 500)
    String website;

}

package com.indonesian.region.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "regencies")
public class Regency {

    @Id
    private String id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "province_id", nullable = false)
    private Province province;

    @Column(name = "name")
    private String name;

    @Column(name = "capital_city")
    private String capitalCity;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "elevation")
    private Float elevation;

    @Column(name = "timezone")
    private Byte timezone;

    @Lob
    @Column(name = "path")
    private String path;

    @Column(name = "status")
    private Byte status;
}

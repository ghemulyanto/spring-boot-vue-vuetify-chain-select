package com.indonesian.region.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "districts")
@Data
public class District {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regency_id", nullable = false)
    private Regency regency;

    private String name;
}

package com.crrm.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;

// this not required for creating new table.
//    @ManyToMany
//    @JoinTable(name = "Bus_stops",
//            joinColumns = @JoinColumn(name = "bus_id"),
//            inverseJoinColumns = @JoinColumn(name = "stops_id"))
//    private Set<Stop> stops = new LinkedHashSet<>();

}

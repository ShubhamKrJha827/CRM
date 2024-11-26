package com.crrm.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Entity
public class BusStop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

    @ManyToOne
    @JoinColumn(name = "stop_id")
    private Stop stop;

    @Column(name="order_number",nullable = false)
    private Integer orderNumber;

    @Column(name = "departure_time", nullable = false)
    private LocalTime departureTime;

}
